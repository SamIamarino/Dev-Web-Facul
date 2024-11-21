/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.entidades.ClassificacaoEtaria;

/**
 *
 * @author Samuel Iamarino
 */
public class ClassificacaoEtariaDAO extends DAO<ClassificacaoEtaria>{

    public ClassificacaoEtariaDAO() throws SQLException {        
    }
    
    @Override
    public void salvar(ClassificacaoEtaria obj) throws SQLException {
        
        PreparedStatement statement = getConnection().prepareStatement(
                "INSERT INTO classificacao_etaria(descricao) " + "VALUES(?);"
        );
        
        statement.setString(1, obj.getDescricao());
        
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public void atualizar(ClassificacaoEtaria obj) throws SQLException {
        
        PreparedStatement statement = getConnection().prepareStatement(
                "UPDATE classificacao_etaria SET descricao = ? WHERE id = ?;"
        );
        
        statement.setString(1, obj.getDescricao());
        statement.setInt(2, obj.getIdClassificacao());
        
        statement.executeUpdate();
        statement.close();
        

    }

    @Override
    public void excluir(ClassificacaoEtaria obj) throws SQLException {
        
        PreparedStatement statement = getConnection().prepareStatement(
                "DELETE FROM classificacao_etaria WHERE id = ?;"
        );
        
        statement.setInt(1, obj.getIdClassificacao());
        
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public List<ClassificacaoEtaria> listarTodos() throws SQLException {

        List<ClassificacaoEtaria> lista = new ArrayList<>();
        
        PreparedStatement statement = getConnection().prepareStatement(
                "SELECT * FROM classificacao_etaria ORDER BY descricao;"
        );
        
        ResultSet set = statement.executeQuery();
        
        while( set.next() ){
            
            ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
            classificacao.setIdClassificacao(set.getInt("id"));
            classificacao.setDescricao(set.getString("descricao"));
            
            lista.add(classificacao);
            
        }
        
        set.close();
        statement.close();
        
        return lista;
        
    }

    @Override
    public ClassificacaoEtaria obterPorId(int id) throws SQLException {

        ClassificacaoEtaria classificacao = null;
        
        PreparedStatement statement = getConnection().prepareStatement( 
               "SELECT * FROM classificacao_etaria WHERE id = ? ORDER BY descricao;"
        );
        
        statement.setInt(1, id);
        
        ResultSet set = statement.executeQuery();
        
        if(set.next()){
            
            classificacao = new ClassificacaoEtaria();
            classificacao.setIdClassificacao(set.getInt("id") );
            classificacao.setDescricao(set.getString("descricao") );
        }
        
        set.close();
        statement.close();
        
        return classificacao;
    }
    
}
