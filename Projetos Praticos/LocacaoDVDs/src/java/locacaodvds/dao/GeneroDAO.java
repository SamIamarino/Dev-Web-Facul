/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.entidades.Genero;

/**
 *
 * @author Samuel Iamarino
 */
public class GeneroDAO extends DAO<Genero>{

    public GeneroDAO() throws SQLException{
        
    }
    
    @Override
    public void salvar(Genero obj) throws SQLException {
         
        PreparedStatement statement = getConnection().prepareStatement(
                "INSERT INTO genero(descricao) " + "VALUES (?);"
        );
        
        statement.setString(1, obj.getDescricao());
        
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public void atualizar(Genero obj) throws SQLException {
        
        PreparedStatement statement = getConnection().prepareStatement(
                "UPDATE genero SET descricao = ? WHERE id = ?;"
        );
        
        statement.setString(1, obj.getDescricao());
        statement.setInt(2, obj.getIdGenero());
        
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public void excluir(Genero obj) throws SQLException {
        
        PreparedStatement statement = getConnection().prepareStatement(
                "DELETE FROM genero WHERE id = ?;"
        );
        
        statement.setInt(1, obj.getIdGenero());
        
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public List<Genero> listarTodos() throws SQLException {
        
        List<Genero> lista = new ArrayList<>();
        
        PreparedStatement statement = getConnection().prepareStatement(
                "SELECT * FROM genero ORDER BY descricao;"
        );
        
        ResultSet set = statement.executeQuery();
        
        while( set.next() ){
            
            Genero gen = new Genero();
            gen.setIdGenero(set.getInt("id"));
            gen.setDescricao(set.getString("descricao"));
            
            lista.add(gen);
            
        }
        
        set.close();
        statement.close();
        
        return lista;
    }

    @Override
    public Genero obterPorId(int id) throws SQLException {
       
        Genero genero = null;
        
        PreparedStatement statement = getConnection().prepareStatement( 
               "SELECT * FROM genero WHERE id = ? ORDER BY descricao;"
        );
        
        statement.setInt(1, id);
        
        ResultSet set = statement.executeQuery();
        
        while(set.next()){
            
            genero = new Genero();
            genero.setIdGenero( set.getInt("id") );
            genero.setDescricao(set.getString("descricao") );
        }
        
        set.close();
        statement.close();
        
        return genero;
    }
    
    
    
}
