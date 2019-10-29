/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kika.cadProdutos.util;

/**
 *
 * @author Alinne
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class Factory {

    private static final String URL = "jdbc:postgresql://localhost:5432/cadProdutos";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "admin";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    
    public static void main(String[] args) {
        Factory.getConnection();
        System.out.println("Acertou!");
    }
} 

