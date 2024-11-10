/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaodvds.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import locacaodvds.dao.DvdDAO;
import locacaodvds.entidades.Dvd;

/**
 *
 * @author Samuel Iamarino
 */
public class DvdServicos {
    
    public List<Dvd> getTodos(){
        
        List<Dvd> lista = new ArrayList<>();
        DvdDAO dao = null;

        try {
            dao = new DvdDAO();
            lista = dao.listarTodos();
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

        return lista;
    }
    
}
