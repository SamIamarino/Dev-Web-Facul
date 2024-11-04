/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.teste;
import java.sql.*;
import locacaodvds.dao.ClassificacaoEtariaDAO;
import locacaodvds.entidades.ClassificacaoEtaria;


/**
 *
 * @author Samuel Iamarino
 */
public class TesteClassificacaoDAO {
    
    public static void main(String[] args) {
        
        ClassificacaoEtariaDAO dao = null;
        
        ClassificacaoEtaria classificacao1 = new ClassificacaoEtaria();
        ClassificacaoEtaria classificacao2 = new ClassificacaoEtaria();
        
        classificacao1.setIdClassificacao(2);
        classificacao1.setDescricao("Descricao Foda Atualizadissima!");
        
        classificacao2.setIdClassificacao(3);
        classificacao2.setDescricao("Descricao Foda Atualizadissima 2!");
        
      
        try{
            
            dao = new ClassificacaoEtariaDAO();
            //dao.salvar(classificacao2);
            
        /*
            for(ClassificacaoEtaria item : dao.listarTodos()){
                System.out.println(item.getIdClassificacao() + " " + item.getDescricao());
            }
        */
        
            System.out.println(dao.obterPorId(3).getDescricao());
            
        }catch(SQLException exception){
            exception.printStackTrace();
        }finally{
            if(dao != null){
                try{
                    dao.fecharConexao();
                }catch(SQLException e){
                    System.out.println("Erro ao fechar conexão");
                    e.printStackTrace();
                }
            }
        }
        
    }
    
}
