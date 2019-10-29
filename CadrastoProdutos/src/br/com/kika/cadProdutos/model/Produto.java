/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kika.cadProdutos.model;

/**
 *
 * @author Alinne
 */
public class Produto {
    private int codigo;
    private String nome;
    private float preco;
    private Especificacao especificacao;

    public Produto(int codigo, String nome, float preco, Especificacao especificacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.especificacao = especificacao;
    }

    public Produto() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Especificacao getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(Especificacao especificacao) {
        this.especificacao = especificacao;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produto{");
        sb.append("codigo=").append(codigo)
                .append(", nome='").append(nome).append('\'')
                .append(", preco=").append(preco)
                .append(", especificacao=").append(especificacao)
                .append('}');
        return sb.toString();
    }
}