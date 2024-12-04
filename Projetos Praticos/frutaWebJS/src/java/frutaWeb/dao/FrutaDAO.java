/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frutaWeb.dao;

import frutaWeb.entidades.Fruta;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Samuel Iamarino
 */
public class FrutaDAO extends DAO<Fruta> {
    
   public FrutaDAO()throws SQLException{
       
   }
   

    @Override
    public void salvar(Fruta obj) throws SQLException {
       
        PreparedStatement statement = getConnection().prepareStatement(
                """
                INSERT INTO fruta (nome,cor) VALUES(?,?)
                """);
        
        statement.setString(1, obj.getNome());
        statement.setString(2,obj.getCor());
        
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public void atualizar(Fruta obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir(Fruta obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Fruta> listarTodos() throws SQLException {
        
        List<Fruta> lista = new ArrayList();
        
        PreparedStatement statement = getConnection().prepareStatement("""
                    SELECT * FROM FRUTA;                                                   
                                                                       
                                                                       """);
    
        
        ResultSet set = statement.executeQuery();
        
        while(set.next()){
           
            Fruta fruta = new Fruta();
            
            fruta.setIdFruta(set.getInt("idfruta"));
            fruta.setNome(set.getString("nome"));
            fruta.setCor(set.getString("cor"));
            
            
            lista.add(fruta);
            
        }
        
        set.close();
        statement.close();
        
        return lista;
    }
    @Override
    public Fruta obterPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    
}
