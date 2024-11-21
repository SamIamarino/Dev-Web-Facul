/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.entidades.*;

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
                        + "data_lancamento, "
                        + "duracao_minutos, "
                        + "classificacao_etaria_id, "
                        + "genero_id) "
                        + "VALUES(?,?,?,?,?,?,?,?);"
        );
        
        statement.setString(1, obj.getTitulo());
        statement.setInt(2, obj.getAnoLancamento());
        statement.setInt(3, obj.getAtorPrincipal().getIdAtor());
        statement.setInt(4, obj.getAtorCoadjuvante().getIdAtor());
        statement.setDate(5, obj.getDataLancamento());
        statement.setInt(6, obj.getDuracaoMinutos());
        statement.setInt(7, obj.getClassificacao().getIdClassificacao());
        statement.setInt(8, obj.getGenero().getIdGenero());
        
        
        statement.executeUpdate();
        statement.close();
        
    }

    @Override
    public void atualizar(Dvd obj) throws SQLException {
        
       PreparedStatement statement = getConnection().prepareStatement(
               "UPDATE dvd "
                       + "SET"
                       + " titulo = ?,"
                       + " ano_lancamento = ?,"
                       + " ator_principal_id = ?,"
                       + " ator_coadjuvante_id = ?,"
                       + " data_lancamento = ?,"
                       + " duracao_minutos = ?,"
                       + " classificacao_etaria_id = ?,"
                       + " genero_id = ?"
                       + " WHERE id = ?;"
       );
       
       statement.setString(1, obj.getTitulo());
       statement.setInt(2, obj.getAnoLancamento());
       statement.setInt(3, obj.getAtorPrincipal().getIdAtor());
       statement.setInt(4, obj.getAtorCoadjuvante().getIdAtor());
       statement.setDate(5, obj.getDataLancamento());
       statement.setInt(6, obj.getDuracaoMinutos());
       statement.setInt(7, obj.getClassificacao().getIdClassificacao());
       statement.setInt(8, obj.getGenero().getIdGenero());
       statement.setInt(9, obj.getDvdID());
       
       statement.executeUpdate();
       statement.close();
    }

    @Override
    public void excluir(Dvd obj) throws SQLException {
        
        PreparedStatement statement = getConnection().prepareStatement(
                "DELETE FROM dvd WHERE id = ?;"
        );
        
        statement.setInt(1, obj.getDvdID());
        
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public List<Dvd> listarTodos() throws SQLException {
        
        List<Dvd> lista = new ArrayList<>();
        
        PreparedStatement statement = getConnection().prepareStatement(
                "SELECT " +
                "dvd.id AS idDVD, " +
                "dvd.titulo AS TituloDVD, " +
                "dvd.ano_lancamento AS AnoLancamentoDvd, " +
                "dvd.data_lancamento AS DataLancamentoDvd, " +
                "dvd.duracao_minutos AS DuracaoMinutosDvd, " +
                "ator_principal.id AS AtorPrincipalId, " +
                "ator_principal.nome AS AtorPrincipalNome, " +
                "ator_principal.sobrenome AS AtorPrincipalSobrenome, " +
                "ator_principal.data_estreia AS AtorPrincipalEstreia, " +
                "ator_coadjuvante.id AS AtorSecundarioId, " +
                "ator_coadjuvante.nome AS AtorSecundarioNome, " +
                "ator_coadjuvante.sobrenome AS AtorSecundarioSobrenome, " +
                "ator_coadjuvante.data_estreia AS AtorSecundarioEstreia, " +
                "classificacao_etaria.id AS idClassificacao, " +
                "classificacao_etaria.descricao AS ClassificacaoDescricao, " +
                "genero.id AS IdGenero, " +
                "genero.descricao AS DescricaoGenero " +
                "FROM dvd " +
                "INNER JOIN ator AS ator_principal ON ator_principal.id = dvd.ator_principal_id " +
                "INNER JOIN ator AS ator_coadjuvante ON ator_coadjuvante.id = dvd.ator_coadjuvante_id " +
                "INNER JOIN classificacao_etaria ON classificacao_etaria.id = dvd.classificacao_etaria_id " +
                "INNER JOIN genero ON genero.id = dvd.genero_id " +
                "ORDER BY dvd.titulo,ator_principal.nome,ator_coadjuvante.nome; "
        );
        
        ResultSet set = statement.executeQuery();
        
        while( set.next() ){
            
           Dvd dvd = new Dvd();
           Ator ator1 = new Ator();
           Ator ator2 = new Ator();
           Genero genero = new Genero();
           ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
           
           //Dvd Config
           dvd.setDvdID( set.getInt("idDVD") );
           dvd.setTitulo(set.getString("TituloDVD") );
           dvd.setAnoLancamento(set.getInt("AnoLancamentoDvd") );
           dvd.setDataLancamento(set.getDate("DataLancamentoDvd") );
           dvd.setDuracaoMinutos(set.getInt("DuracaoMinutosDvd") );
           
           //Ator 1
           dvd.setAtorPrincipal(ator1);
           
           ator1.setIdAtor( set.getInt("AtorPrincipalId") );
           ator1.setNome(set.getString("AtorPrincipalNome") );
           ator1.setSobrenome(set.getString("AtorPrincipalSobrenome") );
           ator1.setDataEstreia(set.getDate("AtorPrincipalEstreia") );
           
           //Ator 2
           dvd.setAtorCoadjuvante(ator2);
           
           ator2.setIdAtor( set.getInt("AtorSecundarioId") );
           ator2.setNome(set.getString("AtorSecundarioNome") );
           ator2.setSobrenome(set.getString("AtorSecundarioSobrenome") );
           ator2.setDataEstreia(set.getDate("AtorSecundarioEstreia") );
           
           //Genero 
           dvd.setGenero(genero);
           
           genero.setIdGenero( set.getInt("IdGenero"));
           genero.setDescricao(set.getString("DescricaoGenero"));
           
           //Classificacão
           dvd.setClassificacao(classificacao);
           
           classificacao.setIdClassificacao(set.getInt("idClassificacao"));
           classificacao.setDescricao(set.getString("ClassificacaoDescricao"));
           
           lista.add(dvd);
           
        }
        set.close();
        statement.close();
        
        return lista ;
    }

    @Override
    public Dvd obterPorId(int id) throws SQLException {
        
        Dvd dvd = null;
        
        PreparedStatement statement = getConnection().prepareStatement(
                "SELECT " +
                "dvd.id AS idDVD, " +
                "dvd.titulo AS TituloDVD, " +
                "dvd.ano_lancamento AS AnoLancamentoDvd, " +
                "dvd.data_lancamento AS DataLancamentoDvd, " +
                "dvd.duracao_minutos AS DuracaoMinutosDvd, " +
                "ator_principal.id AS AtorPrincipalId, " +
                "ator_principal.nome AS AtorPrincipalNome, " +
                "ator_principal.sobrenome AS AtorPrincipalSobrenome, " +
                "ator_principal.data_estreia AS AtorPrincipalEstreia, " +
                "ator_coadjuvante.id AS AtorSecundarioId, " +
                "ator_coadjuvante.nome AS AtorSecundarioNome, " +
                "ator_coadjuvante.sobrenome AS AtorSecundarioSobrenome, " +
                "ator_coadjuvante.data_estreia AS AtorSecundarioEstreia, " +
                "classificacao_etaria.id AS idClassificacao, " +
                "classificacao_etaria.descricao AS ClassificacaoDescricao, " +
                "genero.id AS IdGenero, " +
                "genero.descricao AS DescricaoGenero " +
                "FROM dvd " +
                "INNER JOIN ator AS ator_principal ON ator_principal.id = dvd.ator_principal_id " +
                "INNER JOIN ator AS ator_coadjuvante ON ator_coadjuvante.id = dvd.ator_coadjuvante_id " +
                "INNER JOIN classificacao_etaria ON classificacao_etaria.id = dvd.classificacao_etaria_id " +
                "INNER JOIN genero ON genero.id = dvd.genero_id "
                        + "WHERE dvd.id = ? " +
                "ORDER BY dvd.titulo,ator_principal.nome,ator_coadjuvante.nome ; "
        );
        
        statement.setInt(1, id);
        
        ResultSet set = statement.executeQuery();
        
        if( set.next() ){
           dvd = new Dvd();
           Ator ator1 = new Ator();
           Ator ator2 = new Ator();
           Genero genero = new Genero();
           ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
           
           //Dvd Config
           dvd.setDvdID( set.getInt("idDVD") );
           dvd.setTitulo(set.getString("TituloDVD") );
           dvd.setAnoLancamento(set.getInt("AnoLancamentoDvd") );
           dvd.setDataLancamento(set.getDate("DataLancamentoDvd") );
           dvd.setDuracaoMinutos(set.getInt("DuracaoMinutosDvd") );
           
           //Ator 1
           dvd.setAtorPrincipal(ator1);
           
           ator1.setIdAtor( set.getInt("AtorPrincipalId") );
           ator1.setNome(set.getString("AtorPrincipalNome") );
           ator1.setSobrenome(set.getString("AtorPrincipalSobrenome") );
           ator1.setDataEstreia(set.getDate("AtorPrincipalEstreia") );
           
           //Ator 2
           dvd.setAtorCoadjuvante(ator2);
           
           ator2.setIdAtor( set.getInt("AtorSecundarioId") );
           ator2.setNome(set.getString("AtorSecundarioNome") );
           ator2.setSobrenome(set.getString("AtorSecundarioSobrenome") );
           ator2.setDataEstreia(set.getDate("AtorSecundarioEstreia") );
           
           //Genero 
           dvd.setGenero(genero);
           
           genero.setIdGenero( set.getInt("IdGenero"));
           genero.setDescricao(set.getString("DescricaoGenero"));
           
           //Classificacão
           dvd.setClassificacao(classificacao);
           
           classificacao.setIdClassificacao(set.getInt("idClassificacao"));
           classificacao.setDescricao(set.getString("ClassificacaoDescricao"));
        }
        
        set.close();
        statement.close();
        
        return dvd;
    }
    
}
