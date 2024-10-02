/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package primeiroformularioelServlets;

import entidades.Produto;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Samuel Iamarino
 */
@WebServlet(name = "ProcessaFormularioServlet", urlPatterns = {"/processaFormulario"})
public class ProcessaFormularioServlet extends HttpServlet {

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
        
        //Obtendo dados do formulario
        String codigoBarra = request.getParameter("codigoBarras");
        String descricao = request.getParameter("descricao");
        String unidadeMedida = request.getParameter("unidadeMedida");
        String fabricante = request.getParameter("fabricante");
        int quantidade = 0;
        
        try{
            quantidade = Integer.parseInt(request.getParameter("quantidade"));
        }catch(NumberFormatException exception){
            System.out.println(exception);
        }
        
        Produto produto = new Produto();
        
        //Setando Atributos da instancia do obj.
        produto.setCodigoBarra(codigoBarra);
        produto.setDescricao(descricao);
        produto.setQuantidadeEmbalagem(quantidade);
        produto.setFabricante(fabricante);
        produto.setUnidadeMedida(unidadeMedida);
        
        
        //Setando o nome como o objeto sera visto no Jsp
        request.setAttribute("produtoObtido", produto);
        
        
        //Setando para qual pagina vai e mandando os dados.
        RequestDispatcher dispatcher = request.getRequestDispatcher("exibeDados.jsp");
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
