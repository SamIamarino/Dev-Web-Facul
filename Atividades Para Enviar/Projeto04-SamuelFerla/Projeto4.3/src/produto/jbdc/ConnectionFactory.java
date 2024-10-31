/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produto.jbdc;

import java.sql.*;



/**
 *
 * @author Samuel Iamarino
 */
public class ConnectionFactory {
    
    public static Connection getConnection() throws SQLException {
        
        //Semelhante a conexao criada no node
        return DriverManager.getConnection( "jdbc:mariadb://localhost/testes_padroes" , "root" ,"40028922");
    }
    
}
