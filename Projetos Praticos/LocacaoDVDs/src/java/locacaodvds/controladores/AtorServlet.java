package locacaodvds.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import locacaodvds.dao.AtorDAO;
import java.sql.Date;
import java.time.LocalDate;
import locacaodvds.entidades.Ator;
/**
 *
 * @author Samuel Iamarino
 */
@WebServlet(name = "AtorServlet", urlPatterns = {"/processaAtor"})
public class AtorServlet extends HttpServlet {

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
            AtorDAO dao = null;
            RequestDispatcher disp = null;
            
        try{
            
            dao = new AtorDAO();
            
            if(acao.equals("inserir")){
                
                String nome = request.getParameter("nomeAtor");
                String sobrenome = request.getParameter("sobrenomeAtor");
                Date dataEstreia = Date.valueOf(request.getParameter("dataEstreia"));
                
                Ator ator = new Ator();
                
                ator.setNome(nome);
                ator.setSobrenome(sobrenome);
                ator.setDataEstreia(dataEstreia);
                
                dao.salvar(ator);
                
                disp = request.getRequestDispatcher(
                        "/ator/listagemAtor.jsp"
                );
                
            } else if(acao.equals("alterar")){
                
                int id = Integer.parseInt(request.getParameter("id"));
                
                String nome = request.getParameter("nomeAtor");
                String sobrenome = request.getParameter("sobrenomeAtor");
                Date dataEstreia = Date.valueOf(request.getParameter("dataEstreia"));
                
                Ator ator = new Ator();
                ator.setIdAtor(id);
                ator.setNome(nome);
                ator.setSobrenome(sobrenome);
                ator.setDataEstreia(dataEstreia);
                
                dao.atualizar(ator);
                
                disp = request.getRequestDispatcher(
                        "/ator/listagemAtor.jsp"
                );
                
                
            } else if(acao.equals("deletar")){
                
                int id = Integer.parseInt(request.getParameter("id"));
                Ator ator = new Ator();
                ator.setIdAtor(id);
                
                dao.excluir(ator);
                
                disp = request.getRequestDispatcher(
                        "/ator/listagemAtor.jsp"
                );
                
            } else {
                
                int id = Integer.parseInt(request.getParameter("id"));
                Ator ator = dao.obterPorId(id);
                request.setAttribute("ator", ator);
                
                if(acao.equals("prepararAlteracao")){
                    disp = request.getRequestDispatcher(
                            "ator/editarAtor.jsp"
                    );
                }else if(acao.equals("prepararExclusao")){
                    disp = request.getRequestDispatcher(
                            "ator/excluirAtor.jsp"
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
