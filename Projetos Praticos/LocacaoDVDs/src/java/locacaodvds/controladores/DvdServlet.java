/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package locacaodvds.controladores;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Date;
import locacaodvds.dao.DvdDAO;
import locacaodvds.entidades.Ator;
import locacaodvds.entidades.ClassificacaoEtaria;
import locacaodvds.entidades.Dvd;
import locacaodvds.entidades.Genero;

/**
 *
 * @author Samuel Iamarino
 */
@WebServlet(name = "DvdServlet", urlPatterns = {"/processaDvd"})
public class DvdServlet extends HttpServlet {

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
        
        DvdDAO dao = null;
        RequestDispatcher disp = null;
        String acao = request.getParameter("acao");
        
        try {
            
            dao = new DvdDAO();
            
            if(acao.equals("inserir")){
                
                String titulo = request.getParameter("nomeDvd");
                int anoLancamento = Integer.parseInt(request.getParameter("anoLancamentoDvd"));
                Date dataLancamento = Date.valueOf(request.getParameter("dataLancamentoDvd"));
                int duracao = Integer.parseInt(request.getParameter("duracaoDvd"));
                
                int idAtorPrincipal = Integer.parseInt(request.getParameter("atorPrincipalDvd"));
                int idAtorQuadjuvante = Integer.parseInt(request.getParameter("atorQuadjuvante"));
                int idGenero = Integer.parseInt(request.getParameter("generoDvd"));
                int idClassificacao = Integer.parseInt(request.getParameter("classificacaoDvd"));
                
                Ator atorPrincipal = new Ator();
                atorPrincipal.setIdAtor(idAtorPrincipal);
                
                Ator atorCoadjuvante = new Ator();
                atorCoadjuvante.setIdAtor(idAtorQuadjuvante);
                
                Genero genero = new Genero();
                genero.setIdGenero(idGenero);
                
                ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
                classificacao.setIdClassificacao(idClassificacao);
                
                Dvd dvd = new Dvd();
                
                dvd.setTitulo(titulo);
                dvd.setAnoLancamento(anoLancamento);
                dvd.setDataLancamento(dataLancamento);
                dvd.setDuracaoMinutos(duracao);
                dvd.setAtorPrincipal(atorPrincipal);
                dvd.setAtorCoadjuvante(atorCoadjuvante);
                dvd.setGenero(genero);
                dvd.setClassificacao(classificacao);
                
                dao.salvar(dvd);
                
                disp = request.getRequestDispatcher(
                        "/dvd/listagemDvd.jsp"
                );   
                
            } else if( acao.equals("alterar")){
                
               
                int id = Integer.parseInt(request.getParameter("id"));
                String titulo = request.getParameter("nomeDvd");
                int anoLancamento = Integer.parseInt(request.getParameter("anoLancamentoDvd"));
                Date dataLancamento = Date.valueOf(request.getParameter("dataLancamentoDvd"));
                int duracao = Integer.parseInt(request.getParameter("duracaoDvd"));
                
                int idAtorPrincipal = Integer.parseInt(request.getParameter("atorPrincipalDvd"));
                int idAtorQuadjuvante = Integer.parseInt(request.getParameter("atorQuadjuvante"));
                int idGenero = Integer.parseInt(request.getParameter("generoDvd"));
                int idClassificacao = Integer.parseInt(request.getParameter("classificacaoDvd"));
                
                Ator atorPrincipal = new Ator();
                atorPrincipal.setIdAtor(idAtorPrincipal);
                
                Ator atorCoadjuvante = new Ator();
                atorCoadjuvante.setIdAtor(idAtorQuadjuvante);
                
                Genero genero = new Genero();
                genero.setIdGenero(idGenero);
                
                ClassificacaoEtaria classificacao = new ClassificacaoEtaria();
                classificacao.setIdClassificacao(idClassificacao);
                
                Dvd dvd = new Dvd();
                
                dvd.setDvdID(id);
                dvd.setTitulo(titulo);
                dvd.setAnoLancamento(anoLancamento);
                dvd.setDataLancamento(dataLancamento);
                dvd.setDuracaoMinutos(duracao);
                dvd.setAtorPrincipal(atorPrincipal);
                dvd.setAtorCoadjuvante(atorCoadjuvante);
                dvd.setGenero(genero);
                dvd.setClassificacao(classificacao);
                
                dao.atualizar(dvd);
                
                disp = request.getRequestDispatcher(
                        "/dvd/listagemDvd.jsp"
                );
               
               
                
            } else if(acao.equals("deletar")){
                
                int id = Integer.parseInt(request.getParameter("id"));
                
                Dvd dvd = new Dvd();
                
                dvd.setDvdID(id);
                
                dao.excluir(dvd);
                
                disp = request.getRequestDispatcher(
                        "/dvd/listagemDvd.jsp"
                );
                 
            } else {
                
                int id = Integer.parseInt(request.getParameter("id"));
                Dvd dvd = dao.obterPorId(id);
                request.setAttribute("dvd", dvd);
                
                if(acao.equals("prepararAlteracao")){
                    disp = request.getRequestDispatcher(
                        "/dvd/editarDvd.jsp"
                    );
                }else if( acao.equals("prepararExclusao")){
                    disp = request.getRequestDispatcher(
                        "/dvd/deletarDvd.jsp"
                    );
                }
                
            }
            
            
        } catch ( SQLException exc ) {
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
