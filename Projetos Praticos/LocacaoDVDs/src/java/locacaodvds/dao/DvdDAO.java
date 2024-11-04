/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.dao;

import java.sql.*;
import java.util.List;
import locacaodvds.entidades.Dvd;

/**
 *
 * @author Samuel Iamarino
 */
public class DvdDAO extends DAO<Dvd>{

    public DvdDAO() throws SQLException {
    }

    @Override
    public void salvar(Dvd obj) throws SQLException {
        
        PreparedStatement statement = getConnection().prepareStatement(
                "INSERT INTO dvd("
                        + "titulo, "
                        + "ano_lancamento, "
                        + "ator_principal_id, "
                        + "ator_coadjuvante_id, "
                        + "data_lacamento, "
                        + "duracao_minutos, "
                        + "classificacao_etaria_id, "
                        + "genero_id) "
                        + "VALUES(?,?,?,?,?,?,?,?,?);"
        );
        
        statement.setString(1, obj.getTitulo());
        statement.setInt(2, obj.getAnoLancamento());
        statement.setInt(3, obj.getAtorPrincipal().getIdAtor());
        statement.setInt(4, obj.getAtorCoadjuvante().getIdAtor());
        statement.setDate(5, obj.getDataLancamento());
        statement.setInt(6, obj.getDuracaoMinutos());
        statement.setInt(7, obj.getClassificasao().getIdClassificacao());
        statement.setInt(8, obj.getGenero().getIdGenero());
        
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public void atualizar(Dvd obj) throws SQLException {
        
    }

    @Override
    public void excluir(Dvd obj) throws SQLException {
        
    }

    @Override
    public List<Dvd> listarTodos() throws SQLException {
        
    }

    @Override
    public Dvd obterPorId(int id) throws SQLException {
        
    }
    
}
