/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kika.cadProdutos.main;

/**
 *
 * @author Alinne
 */
import br.com.kika.cadProdutos.dao.ProdutoDao;
import br.com.kika.cadProdutos.model.Especificacao;
import br.com.kika.cadProdutos.model.Produto;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String op;
        ProdutoDao dao = new ProdutoDao();
        Produto p;
        Especificacao e;

        do {

            System.out.println("---| MENU | ---");
            System.out.println("1 - CADASTRAR");
            System.out.println("2 - EDITAR");
            System.out.println("3 - EXCLUIR");
            System.out.println("4 - CONSULTAR");
            System.out.println("0 - SAIR");
            System.out.print(": ");

            op = input.nextLine();

            System.out.println("Opção selecionada: " + op);

            if(op.equals("1")){

                System.out.println("\n--- | CADASTRAR | ---");

                p = new Produto();
                p.setEspecificacao(new Especificacao());

                System.out.print("Nome: ");
                p.setNome(input.nextLine());
                System.out.print("Preço: ");
                p.setPreco(Float.parseFloat(input.nextLine()));
                System.out.print("Fabricante: ");
                p.getEspecificacao().setFabricante(input.nextLine());
                System.out.print("Cor: ");
                p.getEspecificacao().setCor(input.nextLine());
                System.out.print("Sistema: ");
                p.getEspecificacao().setSistema(input.nextLine());
                System.out.print("Detalhes: ");
                p.getEspecificacao().setDetalhes(input.nextLine());


                dao.inserir(p);

                System.out.println("Produto salvo com sucesso!");
            }
            else if(op.equals("2")){
                System.out.println("\n | EDITAR | -");

                System.out.print("Informe o código: ");
                int codigo = Integer.parseInt(input.nextLine());

                p = dao.buscar(codigo);

                if(p != null){
                    System.out.println("Dados Atuais: " + p);
                    System.out.print("Novo nome: ");
                    String entrada = input.nextLine();
                    p.setNome((entrada.equals("")) ? p.getNome() : entrada);

                    System.out.print("Novo preço: ");
                    entrada = input.nextLine();
                    p.setPreco((entrada.equals("") ? p.getPreco() : Integer.parseInt(entrada)));

                    System.out.print("Novo fabricante: ");
                    entrada = input.nextLine();
                    p.getEspecificacao().setFabricante((entrada.equals("") ? p.getEspecificacao().getFabricante() : entrada));

                    System.out.print("Novo cor: ");
                    entrada = input.nextLine();
                    p.getEspecificacao().setCor(entrada.equals("") ? p.getEspecificacao().getCor() : entrada);

                    System.out.print("Novo sistema: ");
                    entrada = input.nextLine();
                    p.getEspecificacao().setSistema(entrada.equals("") ? p.getEspecificacao().getSistema() : entrada);

                    System.out.print("Novos detalhes: ");
                    entrada = input.nextLine();
                    p.getEspecificacao().setDetalhes(entrada.equals("") ? p.getEspecificacao().getDetalhes() : entrada);

                    dao.editar(p);

                    System.out.println("Registro editado com sucesso!");
                }
                else{
                    System.out.println("Registro não encontrado!");
                }
            }
            else if(op.equals("3")){
                System.out.println("\n | EXCLUIR | ");


                System.out.print("Informe o código: ");
                int codigo = Integer.parseInt(input.nextLine());

                p = dao.buscar(codigo);

                if(p != null){
                    dao.remover(p);
                    System.out.println("Registro excluido com sucesso!");
                }
                else{
                    System.out.println("Registro não encontrado!");
                }
            }
            else if(op.equals("4")){
                System.out.println("\n | CONSULTAR | ");


                List<Produto> produtos = dao.listar();
                for(Produto produto : produtos){
                    System.out.println(produto);
                }
            }
        } while (!op.equals("0"));
    }


}
