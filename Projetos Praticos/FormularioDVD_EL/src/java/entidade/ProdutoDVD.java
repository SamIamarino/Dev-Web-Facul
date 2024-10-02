/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author Samuel Iamarino
 */
public class ProdutoDVD {
    private int numeroCopias = 0;
    private String nomeDVD;
    private String atorPrincipal;
    private String atorSecundario;
    private String diretor;
    private String dataLancamento;

    
    //Construtor Padrão.
    public ProdutoDVD() {
        
    }

    //Construtor não Padrao.
    public ProdutoDVD(String nomeDVD, String atorPrincipal, String atorSecundario, String diretor, String dataLancamento) {
        this.nomeDVD = nomeDVD;
        this.atorPrincipal = atorPrincipal;
        this.atorSecundario = atorSecundario;
        this.diretor = diretor;
        this.dataLancamento = dataLancamento;
    }
    
    //Getters e Setters
    public int getNumeroCopias() {
        return numeroCopias;
    }

    public void setNumeroCopias(int numeroCopias) {
        this.numeroCopias = numeroCopias;
    }

    public String getNomeDVD() {
        return nomeDVD;
    }

    public void setNomeDVD(String nomeDVD) {
        this.nomeDVD = nomeDVD;
    }

    public String getAtorPrincipal() {
        return atorPrincipal;
    }

    public void setAtorPrincipal(String atorPrincipal) {
        this.atorPrincipal = atorPrincipal;
    }

    public String getAtorSecundario() {
        return atorSecundario;
    }

    public void setAtorSecundario(String atorSecundario) {
        this.atorSecundario = atorSecundario;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    
    
}
