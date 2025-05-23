/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fruta.jbdc.dao;
import fruta.jbdc.ConnectionFactory;
import java.sql.*;
import java.util.List;



/**
 *
 * @author Samuel Iamarino
 * @param <type>
 */
public abstract class DAO <type> {
    private Connection conexao;
    
    public DAO() throws SQLException{
        conexao = ConnectionFactory.getConnection();
    }
    
    public Connection getConnection(){
        return conexao;
    }
    
    public void fecharConexao() throws SQLException{
            conexao.close();
    }
    
    public abstract void salvar(type obj) throws SQLException;
    
    public abstract void atualizar (type obj) throws  SQLException;
    
    public abstract void excluir( type obj ) throws SQLException;

    public abstract List<type> listarTodos() throws SQLException;
    
    public abstract type obterPorId( int id ) throws SQLException;

}
