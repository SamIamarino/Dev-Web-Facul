/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import entidades.Fruta;
import fruta.jbdc.dao.FrutaDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samuel Iamarino
 */
public class TesteFrutaDAO {
    public static void main(String[] args) {
        
        
        FrutaDAO dao = null;
        Fruta fruta1 = new Fruta();
        Fruta fruta2 = new Fruta();
        
        
        fruta1.setNome("Tomate");
        fruta1.setFrutaCor("vermelho");
        
        fruta2.setNome("maca");
        fruta2.setFrutaCor("azul");
        
        
        
        
        
        try{
            
            dao = new FrutaDAO();
            
            
            
            //dao.salvar(fruta1);
            //dao.excluir(fruta1);
            
           /* for(int i = 0 ; i < lista.size();i++){
                Fruta fruta = (Fruta) lista.get(i);
                System.out.println(fruta.getNome());
            }*/
            
           
            
           System.out.println(dao.obterPorId(12).getNome());
            
        }catch(SQLException e){
            e.printStackTrace();
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
