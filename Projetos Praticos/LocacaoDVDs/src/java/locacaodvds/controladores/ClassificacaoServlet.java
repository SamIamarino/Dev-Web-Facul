package locacaodvds.controladores;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import locacaodvds.entidades.ClassificacaoEtaria;
import locacaodvds.dao.ClassificacaoEtariaDAO;

/**
 *
 * @author Samuel Iamarino
 */
@WebServlet(name = "ClassificacaoServlet", urlPatterns = {"/processaClassificacao"})
public class ClassificacaoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        ClassificacaoEtariaDAO dao = null;
        RequestDispatcher disp = null;
        
        
        try {
            
            dao = new ClassificacaoEtariaDAO();
            
            if(acao.equals("inserir")){
                
                String descricao = request.getParameter("descricaoClassificacao");
                ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
                
                classificacao.setDescricao(descricao);
                
                dao.salvar(classificacao);
                
                disp = request.getRequestDispatcher(
                        "/classificacao_etaria/listagemClassificacao.jsp"
                );
                        
            } else if(acao.equals("alterar")){
                
                String descricao = request.getParameter("editarClassificacao");
                int id = Integer.parseInt(request.getParameter("id"));
                
                ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
                
                classificacao.setIdClassificacao(id);
                classificacao.setDescricao(descricao);
                
                dao.atualizar(classificacao);
                
                disp = request.getRequestDispatcher(
                        "/classificacao_etaria/listagemClassificacao.jsp"
                );
                
            } else if(acao.equals("deletar")){
                
                int id = Integer.parseInt(request.getParameter("id"));
                
                ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
                
                classificacao.setIdClassificacao(id);
                
                dao.excluir(classificacao);
                
                disp = request.getRequestDispatcher(
                        "/classificacao_etaria/listagemClassificacao.jsp"
                );
                
            } else {
                
                int id = Integer.parseInt(request.getParameter("id"));
                ClassificacaoEtaria classificacao = dao.obterPorId(id);
                request.setAttribute("classificacao", classificacao);
                
                if(acao.equals("prepararExclusao")){
                    disp = request.getRequestDispatcher(
                        "classificacao_etaria/deletarClassificacao.jsp"
                    );
                }else if(acao.equals("prepararAlteracao")){
                    disp = request.getRequestDispatcher(
                        "classificacao_etaria/editarClassificacao.jsp"
                    );
                }
                
                
            }
            
            
        }catch( SQLException exc ) {
            exc.printStackTrace();
        } finally {
            if ( dao != null ) {
                try {
                    dao.fecharConexao();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
        }
        
        if ( disp != null ) {
            disp.forward( request, response );
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
