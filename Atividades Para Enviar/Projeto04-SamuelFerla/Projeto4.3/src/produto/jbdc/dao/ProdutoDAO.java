/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produto.jbdc.dao;

import produto.jbdc.entidades.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samuel Iamarino
 */
public class ProdutoDAO extends DAO<Produto>{
     public ProdutoDAO() throws SQLException {
        super();
    }

    @Override
    public void salvar(Produto obj) throws SQLException {
        
        String sql = "INSERT INTO produto (nome,descricao,quantidade) " + "VALUES (? , ?, ?);";
        
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setString(1, obj.getNome());
        statement.setString(2, obj.getDescricao());
        statement.setInt(3, obj.getQuantidadeEstoque());
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public void atualizar(Produto obj) throws SQLException {
        String sql = "UPDATE produto " +
                        "SET" +
                        " nome = ?, " +
                        " descricao = ? " +
                        " quantidade = ? " + 
                        "WHERE" +
                        " idproduto = ?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getDescricao());
        stmt.setInt(3, obj.getQuantidadeEstoque());
        stmt.setInt( 4, obj.getId());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void excluir(Produto obj) throws SQLException {
        String sql = "DELETE FROM produto WHERE id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setInt( 1, obj.getId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Produto> listarTodos() throws SQLException {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {

        Produto produto = new Produto();
        produto.setId(rs.getInt( "idproduto" ) );
        produto.setNome( rs.getString( "nome" ) );
        produto.setQuantidadeEstoque(rs.getInt("quantidade" ) );
        produto.setDescricao(rs.getString( "descricao" ) );

        lista.add( produto );

        }

        rs.close();
        stmt.close();

        return lista;

 }
    

    @Override
    public Produto obterPorId(int id) throws SQLException {
        
        Produto produto = null;
        String sql = "SELECT * FROM produto WHERE idproduto = ?;";
        
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        
        ResultSet set = statement.executeQuery();
        
        if( set.next() ){
            //Pegando o resultado da querry e mandando para um obj
            produto = new Produto();
            produto.setId(set.getInt( "idproduto" ) );
            produto.setNome( set.getString( "nome" ) );
            produto.setDescricao(set.getString( "descricao" ) );
            produto.setQuantidadeEstoque(set.getInt( "quantidade" ) );
        }
        
        set.close();
        statement.close();
        
        
        return produto;
        
    }
}
