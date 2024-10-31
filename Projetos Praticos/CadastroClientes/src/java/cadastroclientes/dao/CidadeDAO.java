/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroclientes.dao;

import cadastroclientes.entidades.Cidade;
import cadastroclientes.entidades.Estado;
import com.sun.xml.xsom.impl.scd.Step;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samuel Iamarino
 */
public class CidadeDAO extends DAO<Cidade>{
    
    public CidadeDAO() throws SQLException{
        
    }

    @Override
    public void salvar(Cidade obj) throws SQLException {
        
        PreparedStatement statement = getConnection().prepareStatement(
                "INSERT INTO cidade(nome , estado_id) "+
                "VALUES (? , ?);"
        );
        
        statement.setString(1, obj.getNome());
        statement.setInt(2, obj.getEstado().getId());
        
    }

    @Override
    public void atualizar(Cidade obj) throws SQLException {
        
        PreparedStatement statement = getConnection().prepareStatement(
                "UPDATE cidade "+
                "SET" + 
                "   nome = ?," + 
                "   estado_id = ? " + 
                "WHERE" + 
                "   id = ? ;"        
        );
        
        statement.setString(1, obj.getNome());
        statement.setInt(2, obj.getEstado().getId());
        statement.setInt(3, obj.getId());
        
        statement.executeUpdate();
        statement.close();
        
        
    }

    @Override
    public void excluir(Cidade obj) throws SQLException {
       
        PreparedStatement statement = getConnection().prepareStatement(
                "DELETE FROM cidade " + 
                "WHERE" + 
                "   id = ?;"
        );
        
        statement.setInt(1, obj.getId());
        
    }

    @Override
    public List<Cidade> listarTodos() throws SQLException {
       
        List<Cidade> lista = new ArrayList<>();
        
        PreparedStatement statement = getConnection().prepareStatement(
                "SELECT" + 
                "    c.id idCidade, " + 
                "    c.nome nomeCidade, " + 
                "    e.id idEstado, " + 
                "    e.nome nomeEstado, " + 
                "    e.sigla siglaEstado " + 
                "FROM" + 
                "    cidade c, " + 
                "    estado e " + 
                "WHERE" + 
                "    c.estado_id = e.id " +
                "ORDER BY c.nome, e.nome, e.sigla;" );
        
        ResultSet rs = statement.executeQuery();
        
        while( rs.next() ){
            
            Cidade c = new Cidade();
            Estado e = new Estado();
 
            c.setId( rs.getInt("idCidade"));
            c.setNome( rs.getString("nomeCidade"));
            c.setEstado( e );
            
            
        }
        
        return lista;
    }

    @Override
    public Cidade obterPorId(int id) throws SQLException {
        
         Cidade cidade = null;

        PreparedStatement statement = getConnection().prepareStatement(
                "SELECT" + 
                "    c.id idCidade, " + 
                "    c.nome nomeCidade, " + 
                "    e.id idEstado, " + 
                "    e.nome nomeEstado, " + 
                "    e.sigla siglaEstado " + 
                "FROM" + 
                "    cidade c, " + 
                "    estado e " + 
                "WHERE" + 
                "    c.id = ? AND " + 
                "    c.estado_id = e.id;" );

        statement.setInt( 1, id );

        ResultSet rs = statement.executeQuery();

        if ( rs.next() ) {

            cidade = new Cidade();
            Estado e = new Estado();

            cidade.setId( rs.getInt( "idCidade" ) );
            cidade.setNome( rs.getString( "nomeCidade" ) );
            cidade.setEstado( e );

            e.setId( rs.getInt( "idEstado" ) );
            e.setNome( rs.getString( "nomeEstado" ) );
            e.setSigla( rs.getString( "siglaEstado" ) );

        }

        rs.close();
        statement.close();

        return cidade;

        
    }
    
}
