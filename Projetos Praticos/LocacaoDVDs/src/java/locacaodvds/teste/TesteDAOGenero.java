/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.teste;

import java.sql.*;
import locacaodvds.dao.GeneroDAO;
import locacaodvds.entidades.Genero;
/**
 *
 * @author Samuel Iamarino
 */
public class TesteDAOGenero {
    public static void main(String[] args) {
        GeneroDAO dao = null;
        
        Genero genero1 = new Genero();
        Genero genero2 = new Genero();
        
        genero1.setIdGenero(4);
        genero1.setDescricao("Descricao ");
        
      
        try{
            
            dao = new GeneroDAO();
            dao.excluir(genero1);
            
            
        }catch(SQLException exception){
            exception.printStackTrace();
        }finally{
            if(dao != null){
                try{
                    dao.fecharConexao();
                }catch(SQLException e){
                    System.out.println("Erro ao fechar conexão");
                    e.printStackTrace();
                }
            }
        }
        
        
    }
}
