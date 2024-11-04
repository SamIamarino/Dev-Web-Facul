/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.teste;

import java.sql.*;
import locacaodvds.dao.AtorDAO;
import locacaodvds.entidades.Ator;
/**
 *
 * @author Samuel Iamarino
 */
public class TesteDAOAtor {
    public static void main(String[] args) {
        AtorDAO dao = null;
        
        Ator ator1 = new Ator();
        Ator ator2 = new Ator();
        
        ator1.setIdAtor(1);
        ator1.setDataEstreia(Date.valueOf("2000-7-12"));
        ator1.setNome("Tobey");
        ator1.setSobrenome("Cruise");
        
        try{
            
            dao = new AtorDAO();
            dao.salvar(ator1);
            
            
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
