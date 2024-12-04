/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package frutaWeb.controladores;

import frutaWeb.entidades.Fruta;
import frutaWeb.dao.FrutaDAO;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Samuel Iamarino
 */
@WebServlet(name = "FrutaServlet", urlPatterns = {"/frutaServlet"})
public class FrutaServlet extends HttpServlet {

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
        
        FrutaDAO dao = null;
        StringBuilder sb = new StringBuilder();
        List<Fruta> frutas = new ArrayList<>();
        Jsonb jb = JsonbBuilder.create();
        
        String nome = request.getParameter("nome");
        String cor = request.getParameter("cor");
        
        try{
        //Salvando no banco    
        dao = new FrutaDAO();
        
        Fruta fruta = new Fruta();
        fruta.setNome(nome);
        fruta.setCor(cor);
        
        dao.salvar(fruta);
        
        for( Fruta frutasPonteiro : dao.listarTodos()){
            
            Fruta frutaTemp = new Fruta();
            frutaTemp.setIdFruta(frutasPonteiro.getIdFruta());
            frutaTemp.setNome(frutasPonteiro.getNome());
            frutaTemp.setCor(frutasPonteiro.getCor());
            
            frutas.add(frutaTemp);
            
        }
        
        try ( PrintWriter out = response.getWriter() ) {
            out.print( jb.toJson( frutas ) );
        }
        
        } catch (SQLException e){
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
        return "FrutaServlet";
    }// </editor-fold>

}
