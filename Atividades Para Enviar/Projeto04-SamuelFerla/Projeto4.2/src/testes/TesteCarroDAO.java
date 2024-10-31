/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import carro.jbdc.dao.CarroDAO;
import carro.jbdc.entidades.Carro;
import java.sql.SQLException;

/**
 *
 * @author Samuel Iamarino
 */
public class TesteCarroDAO {
    public static void main(String[] args) {
        
        Carro carro1 = new Carro();
        Carro carro2 = new Carro();
        
        carro1.setNome("Chevrolet");
        carro1.setAnoFabricacao("1967");
        carro1.setModelo("Impala");
        
        carro2.setNome("Chevrolet");
        carro2.setAnoFabricacao("1967");
        carro2.setModelo("Impala");
        
        
        CarroDAO dao = null;
        
        try{
            
            dao = new CarroDAO();
            dao.salvar(carro1);
            dao.salvar(carro2);
            
            
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
