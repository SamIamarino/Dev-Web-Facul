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
import locacaodvds.entidades.Genero;
import locacaodvds.dao.GeneroDAO;

/**
 *
 * @author Samuel Iamarino
 */
@WebServlet(name = "GeneroServlet", urlPatterns = {"/processaGenero"})
public class GeneroServlet extends HttpServlet {

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
        GeneroDAO dao = null;
        RequestDispatcher disp = null;
        
        
        
        try {
            
            dao = new GeneroDAO();
            
            if(acao.equals("inserir")){
                
                String descricao = request.getParameter("descricaoGenero");
                
                if( descricao.isBlank() ){   
                    disp = request.getRequestDispatcher(
                        "/formularioErro.jsp"
                    );
                    
                }else{
                    Genero genero = new Genero();
                
                    genero.setDescricao(descricao);

                    dao.salvar(genero);

                    disp = request.getRequestDispatcher(
                            "/genero/listagemGenero.jsp"
                    );
                }
            }else if(acao.equals("alterar")){
                
                int id = Integer.parseInt(request.getParameter("id"));
                String descricao = request.getParameter("descricaoGenero");
                
                Genero genero = new Genero();
                genero.setIdGenero(id);
                genero.setDescricao(descricao);
                
                dao.atualizar(genero);
                
                disp  = request.getRequestDispatcher(
                        "/genero/listagemGenero.jsp"
                );
                
            }else if(acao.equals("deletar")){
                
                int id = Integer.parseInt(request.getParameter("id"));
                String descricao = request.getParameter("descricaoGenero");
                
                Genero genero = new Genero();
                genero.setIdGenero(id);
                
                
                dao.excluir(genero);
                
                disp = request.getRequestDispatcher(
                        "/genero/listagemGenero.jsp"
                );
                
            } else {
                
                int id = Integer.parseInt(request.getParameter("id"));
                Genero genero = dao.obterPorId(id);
                request.setAttribute("genero", genero);
                
                
                if(acao.equals("prepararAlteracao")){
                    disp = request.getRequestDispatcher(
                            "genero/editarGenero.jsp"
                    );
                }else if(acao.equals("prepararExclusao")){
                    disp = request.getRequestDispatcher(
                            "genero/excluirGenero.jsp"
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
