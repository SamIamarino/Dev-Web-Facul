/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package formularioDVDServlets;

import entidade.ProdutoDVD;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Samuel Iamarino
 */
@WebServlet(name = "ProcessaFormularioDVDServlet", urlPatterns = {"/processaFormularioDVD"})
public class ProcessaFormularioDVDServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        int numeroCopias = 0;
        String nomeDVD = request.getParameter("nomeDvd");
        String atorPrincipal = request.getParameter("atorPrincipal");
        String atorSecundario = request.getParameter("atorSecundario");
        String diretor = request.getParameter("diretor");
        String dataLancamento = request.getParameter("dataLancamento");
        
        try{
            numeroCopias = Integer.parseInt(request.getParameter("numberOfCopies"));
        } catch (NumberFormatException exception){
            System.out.println(exception);
        }
        
        ProdutoDVD produto = new ProdutoDVD();
        
        produto.setAtorPrincipal(atorPrincipal);
        produto.setAtorSecundario(atorSecundario);
        produto.setDataLancamento(dataLancamento);
        produto.setDiretor(diretor);
        produto.setNumeroCopias(numeroCopias);
        produto.setNomeDVD(nomeDVD);
        
        request.setAttribute("produtoDVD", produto);
        
        //Lembre de colocar a extensão da pagina.
        RequestDispatcher dispatcher = request.getRequestDispatcher("exibeDadosDVD.jsp");
        dispatcher.forward(request, response);
        
        
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
