package produtoWeb.teste;



import java.sql.SQLException;
import produtoWeb.dao.ProdutoDAO;
import produtoWeb.entidades.Produto;

/**
 *
 * @author Samuel Iamarino
 */
public class TesteDAO {
    public static void main(String[] args) {
        ProdutoDAO dao = null;
        
        Produto produto1 = new Produto();
        
        produto1.setIdProduto(1);
        produto1.setDescricao("Descricao mt foda");
        produto1.setQuantidade(1232);
        try{
            
            dao = new ProdutoDAO();
            dao.salvar(produto1);
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
