/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padroesempratica.jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import padroesempratica.jdbc.entidades.Pais;


/**
 *
 * @author Samuel Iamarino
 */
public class PaisDAO extends DAO<Pais> {
    
    public PaisDAO() throws SQLException {
        super();
    }

    @Override
    public void salvar(Pais obj) throws SQLException {
        
        String sql = "INSERT INTO pais (nome,sigla) " + "VALUES (? , ?);";
        
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setString(1, obj.getNome());
        statement.setString(2, obj.getSigla());
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public void atualizar(Pais obj) throws SQLException {
        String sql = "UPDATE pais " +
                        "SET" +
                        " nome = ?, " +
                        " sigla = ? " +
                        "WHERE" +
                        " id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getNome() );
        stmt.setString( 2, obj.getSigla() );
        stmt.setInt( 3, obj.getId());

        stmt.executeUpdate();
        stmt.close();

    }

    @Override
    public void excluir(Pais obj) throws SQLException {
        String sql = "DELETE FROM pais WHERE id = ?;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setInt( 1, obj.getId() );

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Pais> listarTodos() throws SQLException {
        List<Pais> lista = new ArrayList<>();
        String sql = "SELECT * FROM pais;";

        PreparedStatement stmt = getConnection().prepareStatement( sql );
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {

        Pais pais = new Pais();
        pais.setId( rs.getInt( "id" ) );
        pais.setNome( rs.getString( "nome" ) );
        pais.setSigla( rs.getString( "sigla" ) );

        lista.add( pais );

        }

        rs.close();
        stmt.close();

        return lista;

 }
    

    @Override
    public Pais obterPorId(int id) throws SQLException {
        
        Pais pais = null;
        String sql = "SELECT * FROM PAIS WHERE id = ?;";
        
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        
        ResultSet set = statement.executeQuery();
        
        if( set.next() ){
            //Pegando o resultado da querry e mandando para um obj
            pais = new Pais();
            pais.setId(set.getInt("id"));
            pais.setNome(set.getString("nome"));
            pais.setSigla(set.getString("sigla"));
        }
        
        set.close();
        statement.close();
        
        
        return pais;
        
    }
    
}
