/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kika.cadProdutos.dao;

/**
 *
 * @author Alinne
 */
import br.com.kika.cadProdutos.model.Especificacao;
import br.com.kika.cadProdutos.model.Produto;
import br.com.kika.cadProdutos.util.Factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {
    private Connection con;
    private String sql;
    private PreparedStatement st;
    private ResultSet rs;

    public void inserir(Produto produto) throws Exception {
        con = Factory.getConnection();

        sql = "insert into produtos.especificacoes (fabricante, cor, sistema, detalhes) values (?,?,?,? )";
        st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        st.setString(1, produto.getEspecificacao().getFabricante());
        st.setString(2, produto.getEspecificacao().getCor());
        st.setString(3, produto.getEspecificacao().getSistema());
        st.setString(4, produto.getEspecificacao().getDetalhes());
        st.executeUpdate();

        rs = st.getGeneratedKeys();

        int codigoEspecificacao = 0;

        if (rs.next()) {
            codigoEspecificacao = rs.getInt(1);
        }

        sql = "insert into produtos.produtos (nome, preco, especificacao) values (?,?,?)";

        st = con.prepareStatement(sql);
        st.setString(1, produto.getNome());
        st.setDouble(2, produto.getPreco());
        st.setInt(3, codigoEspecificacao);
        st.executeUpdate();
        con.close();
    }

    public List<Produto> listar() throws Exception {
        List<Produto> produtos = new ArrayList<>();
        con = Factory.getConnection();
        sql = "select p.*, e.* from produtos.produtos p, produtos.especificacoes e where p.especificacao = e.codigo";
        st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Produto p = new Produto();
            p.setEspecificacao(new Especificacao());

            p.setCodigo(rs.getInt("codigo"));
            p.setNome(rs.getString("nome"));
            p.setPreco(rs.getInt("preco"));

            p.getEspecificacao().setCodigo(rs.getInt("especificacao"));
            p.getEspecificacao().setFabricante(rs.getString("fabricante"));
            p.getEspecificacao().setCor(rs.getString("cor"));
            p.getEspecificacao().setSistema(rs.getString("sistema"));
            p.getEspecificacao().setDetalhes(rs.getString("detalhes"));

            produtos.add(p);
        }
        con.close();
        return produtos;
    }

    public Produto buscar(int codigo) throws Exception {
        Produto p = null;
        con = Factory.getConnection();
        sql = "select p.*, e.* from produtos.produtos p, produtos.especificacoes e where p.codigo = ? and p.especificacao = e.codigo";
        st = con.prepareStatement(sql);
        st.setInt(1, codigo);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            p = new Produto();
            p.setEspecificacao(new Especificacao());

            p.setCodigo(rs.getInt("codigo"));
            p.setNome(rs.getString("nome"));
            p.setPreco(rs.getInt("preco"));
            p.getEspecificacao().setCodigo(rs.getInt("especificacao"));
            p.getEspecificacao().setFabricante(rs.getString("fabricante"));
            p.getEspecificacao().setCor(rs.getString("cor"));
            p.getEspecificacao().setSistema(rs.getString("sistema"));
            p.getEspecificacao().setDetalhes(rs.getString("detalhes"));
        }
        con.close();
        return p;
    }


    public void remover(Produto produto) throws Exception {
        con = Factory.getConnection();

        sql = "delete from produtos.produtos where codigo = ?";

        st = con.prepareStatement(sql);
        st.setInt(1, produto.getCodigo());
        st.executeUpdate();

        con.close();
    }

    public void editar(Produto produto) throws Exception{
        con = Factory.getConnection();

        sql = "update produtos.produtos set nome = ?, preco = ? where codigo = ?";

        st = con.prepareStatement(sql);
        st.setString(1, produto.getNome());
        st.setFloat(2, produto.getPreco());
        st.setInt(3, produto.getCodigo());
        st.executeUpdate();

        sql = "update produtos.especificacoes set fabricante = ?, cor = ?, sistema = ?, detalhes = ? where codigo = ?";

        st = con.prepareStatement(sql);
        st.setString(1, produto.getEspecificacao().getFabricante());
        st.setString(2, produto.getEspecificacao().getCor());
        st.setString(3, produto.getEspecificacao().getSistema());
        st.setString(4, produto.getEspecificacao().getDetalhes());
        st.setInt(5, produto.getEspecificacao().getCodigo());
        st.executeUpdate();

        con.close();
    }
}