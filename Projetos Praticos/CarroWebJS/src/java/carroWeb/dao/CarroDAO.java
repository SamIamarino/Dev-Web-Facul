package carroWeb.dao;

import carroWeb.entidades.Carro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Samuel Iamarino
 */
public class CarroDAO extends DAO<Carro>{
    
    public CarroDAO() throws SQLException{
        
    }

    @Override
    public void salvar(Carro obj) throws SQLException {
        
        PreparedStatement statement = getConnection().prepareStatement(
                """
                INSERT INTO carros (nome,modelo,ano_fabricacao) 
                VALUES (?,?,?);                                                
                """);
     
        statement.setString(1, obj.getNome());
        statement.setString(2, obj.getModelo());
        statement.setInt(3, obj.getAnoModelo());
        
        statement.executeUpdate();
        
        statement.close();
    }

    @Override
    public void atualizar(Carro obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir(Carro obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Carro> listarTodos() throws SQLException {
        
        List<Carro> lista = new ArrayList<>();
        
        PreparedStatement statement = getConnection().prepareStatement(
                """
                SELECT * FROM carros 
                """);
        
        ResultSet set = statement.executeQuery();
        
        while(set.next()){
            
            Carro carro = new Carro();
            
            carro.setIdCarro(set.getInt("idcarros"));
            carro.setNome(set.getString("nome"));
            carro.setModelo(set.getString("modelo"));
            carro.setAnoModelo(set.getInt("ano_fabricacao"));
            
            lista.add(carro);
        }
        
        set.close();
        statement.close();
        
        return lista;
        
    }

    @Override
    public Carro obterPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
