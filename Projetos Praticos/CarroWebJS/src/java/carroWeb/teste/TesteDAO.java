package carroWeb.teste;

import carroWeb.dao.CarroDAO;
import carroWeb.entidades.Carro;
import java.sql.SQLException;

/**
 *
 * @author Samuel Iamarino
 */
public class TesteDAO {
    public static void main(String[] args) {
        CarroDAO dao = null;
        
        Carro carro1 = new Carro();
        
        carro1.setIdCarro(1);
        carro1.setAnoModelo(1999);
        carro1.setNome("Fiat");
        carro1.setModelo("Marea");
        
        
        
        try{
            
            dao = new CarroDAO();
            dao.salvar(carro1);
            System.out.println(dao.listarTodos().getFirst().getNome());
            
            
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
