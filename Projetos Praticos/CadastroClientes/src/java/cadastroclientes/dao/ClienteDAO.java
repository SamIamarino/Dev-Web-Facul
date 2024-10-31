/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroclientes.dao;

import cadastroclientes.entidades.Cliente;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Samuel Iamarino
 */
public class ClienteDAO extends DAO<Cliente>{
    
    public ClienteDAO() throws SQLException{
        
    }

    @Override
    public void salvar(Cliente obj) throws SQLException {
           PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO " + 
                "cliente(" + 
                "    nome, " + 
                "    sobrenome, " + 
                "    dataNascimento, " + 
                "    cpf, " + 
                "    email, " + 
                "    logradouro, " + 
                "    numero, " + 
                "    bairro, " + 
                "    cep, " + 
                "    cidade_id ) " + 
                "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? );" );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getSobrenome() );
        stmt.setDate(3, obj.getDataNascimento()); //nao se se isso ta certo nao k
        stmt.setString( 4, obj.getCpf() );
        stmt.setString( 5, obj.getEmail() );
        stmt.setString( 6, obj.getLogradouro() );
        stmt.setString( 7, obj.getNumero() );
        stmt.setString( 8, obj.getBairro() );
        stmt.setString( 9, obj.getCep() );
        stmt.setInt( 10, obj.getCidade().getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Cliente obj) throws SQLException {
         PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE cliente " + 
                "SET" + 
                "    nome = ?, " + 
                "    sobrenome = ?," + 
                "    dataNascimento = ?, " + 
                "    cpf = ?, " + 
                "    email = ?, " + 
                "    logradouro = ?, " + 
                "    numero = ?, " + 
                "    bairro = ?, " + 
                "    cep = ?, " + 
                "    cidade_id = ? " + 
                "WHERE" + 
                "    id = ?;" );

        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getSobrenome() );
        stmt.setDate( 3, obj.getDataNascimento() );
        stmt.setString( 4, obj.getCpf() );
        stmt.setString( 5, obj.getEmail() );
        stmt.setString( 6, obj.getLogradouro() );
        stmt.setString( 7, obj.getNumero() );
        stmt.setString( 8, obj.getBairro() );
        stmt.setString( 9, obj.getCep() );
        stmt.setInt( 10, obj.getCidade().getId() );
        stmt.setInt( 11, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Cliente obj) throws SQLException {
        
       
        
    }

    @Override
    public List<Cliente> listarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente obterPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
