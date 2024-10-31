
package fruta.jbdc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entidades.Fruta;
import fruta.jbdc.dao.DAO;

/**
 *
 * @author Samuel Iamarino
 */
public class FrutaDAO extends DAO<Fruta>{
    
    
    public FrutaDAO() throws SQLException{
        super();    
    }

    @Override
    public void salvar(Fruta obj) throws SQLException {
        
        String sql = "INSERT INTO fruta(nome,cor)"  + "VALUES (? , ? );";
        
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setString(1, obj.getNome());
        statement.setString(2, obj.getFrutaCor());
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public void atualizar(Fruta obj) throws SQLException {
        
       String sql = "UPDATE fruta " +
                        "SET" +
                        " nome = ?, " +
                        " cor = ? " +
                        "WHERE" +
                        " idFruta = ?;";
        
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setString(1, obj.getNome());
        statement.setString(2, obj.getFrutaCor());
        statement.setInt(3, obj.getIdFruta());
        
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void excluir(Fruta obj) throws SQLException {
        String sql = "DELETE FROM fruta WHERE idFruta = ?;" ;
        
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, obj.getIdFruta());
        
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public List<Fruta> listarTodos() throws SQLException {
        List<Fruta> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM fruta;";
        
        PreparedStatement statement = getConnection().prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        
        while( rs.next() ){
            Fruta fruta = new Fruta();
            fruta.setIdFruta( rs.getInt( "idFruta" ) );
            fruta.setNome( rs.getString("nome" ) );
            fruta.setFrutaCor( rs.getString("cor" ));
            
            lista.add(fruta);
            
        }
        
        rs.close();
        statement.close();
        
        return lista;
    }

    @Override
    public Fruta obterPorId(int id) throws SQLException {
        Fruta fruta = null;
        
        String sql = "SELECT * FROM fruta WHERE idFruta = ? ;";
        
        PreparedStatement statement = getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        
        ResultSet rs = statement.executeQuery();
        
        if(rs.next()){
            fruta = new Fruta();
            fruta.setIdFruta( rs.getInt("idFruta"));
            fruta.setFrutaCor( rs.getString("cor") );
            fruta.setNome( rs.getString("nome") );
        }
        
        rs.close();
        statement.close();
        
        return fruta;
        
    }
    
}
