/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frutaWeb.testes;
import frutaWeb.dao.FrutaDAO;
import frutaWeb.entidades.Fruta;
import java.sql.*;
/**
 *
 * @author Samuel Iamarino
 */
public class TesteDAO {
    public static void main(String[] args) {
        
        FrutaDAO dao = null;
        
        Fruta fruta1 = new Fruta();
        Fruta fruta2 = new Fruta();
        
        fruta1.setCor("Azul");
        fruta1.setNome("BlueBerry");
        
        
        try{
            
            dao = new FrutaDAO();
            dao.listarTodos();
            System.out.println(dao.listarTodos());
            
            
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
