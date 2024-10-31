/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroclientes.dao;
import cadastroclientes.entidades.Estado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samuel Iamarino
 */
public class EstadoDAO extends DAO<Estado>{
    
    public EstadoDAO() throws SQLException{
    }

    @Override
    public void salvar(Estado obj) throws SQLException {
        
        PreparedStatement statement = getConnection().prepareStatement("INSERT INTO "+ "estado( nome, sigla ) " + "VALUES( ?, ? );");
        statement.setString(1, obj.getNome());
        statement.setString(2, obj.getSigla());
        
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public void atualizar(Estado obj) throws SQLException {
        
        PreparedStatement statement = getConnection().prepareStatement(
                "UPDATE estado " + 
                "SET " + 
                "   nome = ?," + 
                "   sigla = ? " + 
                "   WHERE" + 
                "   id = ?;"
        );
        
        statement.setString(1, obj.getNome());
        statement.setString(2, obj.getSigla());
        statement.setInt(3, obj.getId());
        
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public void excluir(Estado obj) throws SQLException {
        
        PreparedStatement stetement = getConnection().prepareStatement(
                "DELETE FROM estado " + 
                "WHERE "+
                "   id = ?;"
        );
        
        stetement.setInt(1, obj.getId());
        
        stetement.executeUpdate();
        stetement.close();
        
    }

    @Override
    public List<Estado> listarTodos() throws SQLException {
        
        List<Estado> lista = new ArrayList<>();
        
        PreparedStatement statement = getConnection().prepareStatement(
                "SELECT * FROM estado "+ 
                "ORDER BY nome,sigla;"
        );
        
        ResultSet set = statement.executeQuery();
        
        while(set.next()){
            
            //Estado temporario para adicionar na lista
            Estado e = new Estado();
            
            e.setId( set.getInt("id") );
            e.setNome( set.getString("nome") );
            e.setNome( set.getString("sigla") );
            
            lista.add( e );
            
        }
        
        set.close();
        statement.close();
        
        return lista;
    }

    @Override
    public Estado obterPorId(int id) throws SQLException {
        
        Estado estado = null;
        
        PreparedStatement statement = getConnection().prepareStatement(
                "SELECT * FROM estado "+
                "WHERE id = ?;"        
        );
        
        statement.setInt( 1, id );
        
        ResultSet set = statement.executeQuery();
        
        while(set.next()){
            
            estado = new Estado();
            
            estado.setId( set.getInt("id"));
            estado.setNome(set.getString("nome"));
            estado.setSigla(set.getString("sigla"));
            
        }
        
        set.close();
        statement.close();
        
        return estado;
        
    }
    
}
