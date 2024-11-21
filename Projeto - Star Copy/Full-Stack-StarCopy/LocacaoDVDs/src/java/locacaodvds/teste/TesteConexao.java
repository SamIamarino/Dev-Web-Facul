/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.teste;

import java.sql.Connection;
import java.sql.SQLException;
import locacaodvds.jbdc.ConnectionFactory;
import locacaodvds.servicos.AtorServicos;
/**
 *
 * @author Samuel Iamarino
 */
public class TesteConexao {
    public static void main(String[] args) {
        
        AtorServicos servico = new AtorServicos();
        
        try{
            
            Connection conexao = ConnectionFactory.getConnection();
            System.out.println("Conexao criada com sucesso!");
            
        }catch(SQLException e){
            System.out.println("Erro ao fazer a conexao!");
            e.printStackTrace();
        }
    }
}
