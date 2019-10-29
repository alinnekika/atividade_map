/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kika.cadProdutos.teste;

/**
 *
 * @author Alinne
 */
import br.com.kika.cadProdutos.util.Factory;


public class Teste {
    public static void main(String[] args) {

        if (Factory.getConnection() != null)
            System.out.println("Failed!");
    }
}
