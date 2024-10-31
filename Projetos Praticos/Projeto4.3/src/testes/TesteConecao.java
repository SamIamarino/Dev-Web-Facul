/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import java.sql.Connection;
import java.sql.SQLException;
import produto.jbdc.ConnectionFactory;
/**
 *
 * @author Samuel Iamarino
 */
public class TesteConecao {
    public static void main(String[] args) {
        try{
            
           Connection conexao = ConnectionFactory.getConnection();
           System.out.println("Conexao criada com sucesso!");
            
        }catch(SQLException e){
            System.out.println("Erro ao fazer a conexao!");
            e.printStackTrace();
        }
    }
   
}
