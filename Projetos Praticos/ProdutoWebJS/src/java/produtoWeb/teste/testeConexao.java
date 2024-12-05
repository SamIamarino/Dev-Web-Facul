/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtoWeb.teste;
import produtoWeb.jbdc.ConnectionFactory;
import java.sql.*;
/**
 *
 * @author Samuel Iamarino
 */
public class testeConexao {
    public static void main(String[] args) {
        
        try{
            Connection con = ConnectionFactory.getConnection();
            System.out.println("funfo");
        }catch(SQLException e){
            System.out.println("n funfo");
            e.printStackTrace();
        }
        
    }
}
