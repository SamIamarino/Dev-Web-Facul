/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carro.jbdc.dao;

import carro.jbdc.entidades.Carro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author Samuel Iamarino
 */
public class CarroDAO extends DAO<Carro> {
    
    public CarroDAO() throws SQLException {
        super();
    }

    @Override
    public void salvar(Carro obj) throws SQLException {
        
        String sql = "INSERT INTO carro (nome,modelo,anoFabricacao) " + "VALUES (? , ?, ?);";
        
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setString(1, obj.getNome());
        statement.setString(2, obj.getModelo());
        statement.setString(3, obj.getAnoFabricacao());
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public void atualizar(Carro obj) throws SQLException {
        String sql = "UPDATE carro " +
                        "SET" +
                        " nome = ?, " +
                        " modelo = ? " +
                        " anoFabricacao = ? " + 
                        "WHERE" +
                        " idcarro = ?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getModelo());
        stmt.setString(3, obj.getAnoFabricacao());
        stmt.setInt( 4, obj.getIdCarro());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void excluir(Carro obj) throws SQLException {
        String sql = "DELETE FROM carro WHERE id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setInt( 1, obj.getIdCarro());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Carro> listarTodos() throws SQLException {
        List<Carro> lista = new ArrayList<>();
        String sql = "SELECT * FROM carro;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {

        Carro carro = new Carro();
        carro.setIdCarro(rs.getInt( "idcarro" ) );
        carro.setNome( rs.getString( "nome" ) );
        carro.setAnoFabricacao(rs.getString( "anoFabricacao" ) );
        carro.setModelo(rs.getString( "modelo" ) );

        lista.add( carro );

        }

        rs.close();
        stmt.close();

        return lista;

 }
    

    @Override
    public Carro obterPorId(int id) throws SQLException {
        
        Carro carro = null;
        String sql = "SELECT * FROM carro WHERE idcarro = ?;";
        
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        
        ResultSet set = statement.executeQuery();
        
        if( set.next() ){
            //Pegando o resultado da querry e mandando para um obj
            carro = new Carro();
            carro.setIdCarro(set.getInt( "idcarro" ) );
            carro.setNome( set.getString( "nome" ) );
            carro.setAnoFabricacao(set.getString( "anoFabricacao" ) );
            carro.setModelo(set.getString( "modelo" ) );
        }
        
        set.close();
        statement.close();
        
        
        return carro;
        
    }
    
}
