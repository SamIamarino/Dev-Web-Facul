/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import java.sql.*;
import padroesempratica.jdbc.dao.PaisDAO;
import padroesempratica.jdbc.entidades.Pais;


/**
 *
 * @author Samuel Iamarino
 */
public class TestePaisDAO {
    
    public static void main(String[] args) {
            
        Pais pais = new Pais();
        Pais pais2 = new Pais();
        
        pais.setNome("Brasil");
        pais.setSigla("BR");
        
        pais2.setNome("Turquia");
        pais2.setSigla("TQ");
        
        PaisDAO dao = null;
        
        try{
            
            dao = new PaisDAO();
            dao.salvar( pais );
            dao.salvar(pais2);
            
            
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            if( dao != null){
                try{
                    dao.fecharConexao();
                }catch (SQLException e){
                    System.out.println("Erro ao fechar conexão");
                    e.printStackTrace();
                }
            }
        }
       
            
    }
    
}
