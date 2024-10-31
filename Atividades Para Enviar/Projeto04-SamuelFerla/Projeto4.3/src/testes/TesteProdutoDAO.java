/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import java.sql.SQLException;
import produto.jbdc.ConnectionFactory;
import produto.jbdc.dao.ProdutoDAO;
import produto.jbdc.entidades.Produto;

/**
 *
 * @author Samuel Iamarino
 */
public class TesteProdutoDAO {
    public static void main(String[] args) {
         
        Produto produto1 = new Produto();
        
        
        produto1.setNome("Fone QCY");
        produto1.setDescricao("Os fones da marca QCY são conhecidos por oferecer um bom "
                + "equilíbrio entre custo e qualidade, "
                + "focando principalmente em fones de ouvido true wireless (TWS).");
        produto1.setQuantidadeEstoque(57);
        
        ProdutoDAO dao = null;
        
        try{
            
            dao = new ProdutoDAO();
            dao.salvar(produto1);
           
            
            
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            if( dao != null){
                try{
                    dao.fecharConexao();
                }catch (SQLException e){
                    System.out.println("Erro ao fechar conexão");
                    e.printStackTrace();
                }
            }
        }
       
    }
}
