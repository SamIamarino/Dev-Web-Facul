/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.entidades;
import java.sql.Date;

/**
 *
 * @author Samuel Iamarino
 */
public class Dvd {
    
    private String titulo;
    private Ator atorPrincipal; //idAtor
    private Ator atorCoadjuvante; //idAtor
    private Date dataLancamento; //Date sql pelo amor de Deus user o Date.valueOf() pra testar
    private Genero genero;
    private ClassificacaoEtaria classificasao; //idClassificacao
    private int dvdID;
    private int anoLancamento;
    private int duracaoMinutos;

    public int getDvdID() {
        return dvdID;
    }

    public void setDvdID(int dvdID) {
        this.dvdID = dvdID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Ator getAtorPrincipal() {
        return atorPrincipal;
    }

    public void setAtorPrincipal(Ator atorPrincipal) {
        this.atorPrincipal = atorPrincipal;
    }

    public Ator getAtorCoadjuvante() {
        return atorCoadjuvante;
    }

    public void setAtorCoadjuvante(Ator atorCoadjuvante) {
        this.atorCoadjuvante = atorCoadjuvante;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public ClassificacaoEtaria getClassificasao() {
        return classificasao;
    }

    public void setClassificasao(ClassificacaoEtaria classificasao) {
        this.classificasao = classificasao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
}
