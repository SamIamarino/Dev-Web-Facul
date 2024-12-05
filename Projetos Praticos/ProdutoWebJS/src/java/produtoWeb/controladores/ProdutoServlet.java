/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package produtoWeb.controladores;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import produtoWeb.dao.ProdutoDAO;
import produtoWeb.entidades.Produto;

/**
 *
 * @author Samuel Iamarino
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/listarProdutos"})
public class ProdutoServlet extends HttpServlet {

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
        response.setContentType( "application/json;charset=UTF-8" );
        
        ProdutoDAO dao = null;
        List<Produto> produtos = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Jsonb jb = JsonbBuilder.create();
        
        
        String descricao = request.getParameter("descricao");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        
        try{
            
            dao = new ProdutoDAO();
            
            Produto produto = new Produto();
            produto.setDescricao(descricao);
            produto.setQuantidade(quantidade);
            
            dao.salvar(produto);
            
            for(Produto produtoPonteiro : dao.listarTodos()){
                
                Produto produtoTemp = new Produto();
                
                produtoTemp.setIdProduto(produtoPonteiro.getIdProduto());
                produtoTemp.setDescricao(produtoPonteiro.getDescricao());
                produtoTemp.setQuantidade(produtoPonteiro.getQuantidade());
                
                produtos.add(produtoTemp);
                
            }
            
            try ( PrintWriter out = response.getWriter() ) {
                out.print( jb.toJson( produtos ) );
            }
            
            
            
            
        }catch(SQLException e){
            e.printStackTrace();
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
