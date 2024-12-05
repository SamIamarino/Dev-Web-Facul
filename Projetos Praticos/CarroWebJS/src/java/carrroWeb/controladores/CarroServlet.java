package carrroWeb.controladores;

import carroWeb.dao.CarroDAO;
import carroWeb.entidades.Carro;
import jakarta.json.JsonBuilderFactory;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 *
 * @author Samuel Iamarino
 */
@WebServlet(name = "CarroServlet", urlPatterns = {"/listarCarros"})
public class CarroServlet extends HttpServlet {

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
        
        CarroDAO dao = null;
        StringBuilder sb = new StringBuilder();
        List<Carro> carros =  new ArrayList<>();
        Jsonb jb = JsonbBuilder.create();
        
        String nome = request.getParameter("nome");
        String modelo = request.getParameter("modelo");
        int anoModelo = Integer.parseInt(request.getParameter("anoFabricacao"));
        
        try{
        
            dao = new CarroDAO();
            
            Carro carro = new Carro();
            carro.setAnoModelo(anoModelo);
            carro.setNome(nome);
            carro.setModelo(modelo);
            
            dao.salvar(carro);
            
            
            //For fazendo carros para mandar no JSON para ser consumido no front-end 
            for(Carro carroPonteiro: dao.listarTodos()){
                
                Carro carroTemp = new Carro();
                carroTemp.setIdCarro(carroPonteiro.getIdCarro());
                carroTemp.setNome(carroPonteiro.getNome());
                carroTemp.setModelo(carroPonteiro.getModelo());
                carroTemp.setAnoModelo(carroPonteiro.getAnoModelo());
                
                carros.add(carroTemp);
                
            }
            
            try ( PrintWriter out = response.getWriter() ) {
                out.print( jb.toJson( carros ) );
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
