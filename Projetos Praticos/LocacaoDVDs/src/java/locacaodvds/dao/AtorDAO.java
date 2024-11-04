/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.dao;

import locacaodvds.entidades.Ator;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Samuel Iamarino
 */
public class AtorDAO extends DAO<Ator> {
    
    public AtorDAO() throws SQLException{
        
    }

    @Override
    public void salvar(Ator obj) throws SQLException {
        
        PreparedStatement statement = getConnection().prepareStatement(
                "INSERT INTO ator (nome,sobrenome,data_estreia) "  +  "VALUES (?,?,?);"
        );
        
        statement.setString(1, obj.getNome());
        statement.setString(2, obj.getSobrenome());
        statement.setDate(3, obj.getDataEstreia());
        
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void atualizar(Ator obj) throws SQLException {
        
        PreparedStatement statement = getConnection().prepareStatement(
                "UPDATE ator SET nome = ? , sobrenome = ? , data_estreia = ? WHERE id = ?;"
        );
        
        statement.setString(1, obj.getNome());
        statement.setString(2, obj.getSobrenome());
        statement.setDate(3, obj.getDataEstreia());
        statement.setInt(4, obj.getIdAtor());
        
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public void excluir(Ator obj) throws SQLException {
        
        PreparedStatement statement = getConnection().prepareStatement(
                "DELETE FROM ator WHERE id = ? ;"
        );
        
        statement.setInt(1, obj.getIdAtor());
        
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public List<Ator> listarTodos() throws SQLException {
        
        List<Ator> lista = new ArrayList();
        
        PreparedStatement statement = getConnection().prepareStatement(
                "SELECT * FROM ator ORDER BY nome, sobrenome, data_estreia;"
        );
        
        ResultSet set = statement.executeQuery();
        
        while(set.next()){
            
            Ator ator = new Ator();
            
            ator.setIdAtor( set.getInt("id"));
            ator.setNome(set.getString("nome"));
            ator.setSobrenome(set.getString("sobrenome"));
            ator.setDataEstreia(set.getDate("data_estreia"));
            
            lista.add(ator);
            
        }
        
        set.close();
        statement.close();
        
        
        return lista;
    }

    @Override
    public Ator obterPorId(int id) throws SQLException {
     
        Ator ator = null;
        
        PreparedStatement statement = getConnection().prepareStatement(
                "SELECT * FROM ator WHERE id = ?;"
        );
        
        statement.setInt(1, id);
        
        ResultSet set = statement.executeQuery();
        
        while(set.next()){
            
            ator = new Ator();
            ator.setIdAtor(set.getInt("id"));
            ator.setNome(set.getString("nome"));
            ator.setSobrenome(set.getString("sobrenome"));
            ator.setDataEstreia(set.getDate("data_estreia"));
            
        }
        
        set.close();
        statement.close();
        
        return ator;
        
    }
    
}
