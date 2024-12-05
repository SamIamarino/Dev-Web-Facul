/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtoWeb.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import produtoWeb.entidades.Produto;

/**
 *
 * @author Samuel Iamarino
 */
public class ProdutoDAO extends DAO<Produto>{

    
    public ProdutoDAO() throws SQLException{
        
    }
    
    @Override
    public void salvar(Produto obj) throws SQLException {
       
        PreparedStatement statement = getConnection().prepareStatement(
                """
                INSERT INTO produto(descricao,quantidade) VALUES (?,?);
                """);
        
        statement.setString(1, obj.getDescricao());
        statement.setInt(2, obj.getQuantidade());
        
        statement.executeUpdate();
        
        statement.close();
        
    }

    @Override
    public void atualizar(Produto obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir(Produto obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Produto> listarTodos() throws SQLException {
       
        List<Produto> lista = new ArrayList<>();
        
        PreparedStatement statement = getConnection().prepareStatement(
                """
                SELECT * FROM produto;
                """);
        
        ResultSet set = statement.executeQuery();
        
        while( set.next() ){
            
            Produto produto = new Produto();
            
            produto.setIdProduto( set.getInt("idproduto"));
            produto.setDescricao(set.getString("descricao"));
            produto.setQuantidade(set.getInt("quantidade"));
            
            lista.add(produto);
        }
        
        set.close();
        statement.close();
        
        return lista;
    }

    @Override
    public Produto obterPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
