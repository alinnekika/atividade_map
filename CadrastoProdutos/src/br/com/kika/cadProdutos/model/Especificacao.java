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
public class Especificacao {
    private int codigo;
    private String fabricante;
    private String cor;
    private String sistema;
    private String detalhes;

    public Especificacao(int codigo, String nome, String fabricante, String cor, String sistema, String detalhes) {
        this.codigo = codigo;
        this.fabricante = fabricante;
        this.cor = cor;
        this.sistema = sistema;
        this.detalhes = detalhes;
    }

    public Especificacao() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }



    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Especificacao{");
        sb.append("codigo=").append(codigo)
                .append(", fabricante='").append(fabricante).append('\'')
                .append(", cor='").append(cor).append('\'')
                .append(", sistema='").append(sistema).append('\'')
                .append(", detalhes='").append(detalhes).append('\'')
                .append('}');
        return sb.toString();
    }
}
