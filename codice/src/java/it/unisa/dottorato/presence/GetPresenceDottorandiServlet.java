/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.dottorato.presence;
import it.unisa.dottorato.account.Account;
import it.unisa.dottorato.exception.IdException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/** Servlet incaricata ad effettuare la richiesta di ricerca della liste delle presenze
 * di una lezione
 *
 * @author Rembor
 */
@WebServlet(name = "GetPresenceDottorandi", urlPatterns = {"/GetPresenceDottorandi"})
public class GetPresenceDottorandiServlet extends HttpServlet{
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request oggetto request per accedere ai parametri inviati attraverso
     * il metodo getParameter per ottenere l'id della lezione idLesson per effettuare
     * la richiesta di ricerca e visualizzazione delle presenze di una lezione
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
PrintWriter out = response.getWriter();

        try {
             JSONObject result = new JSONObject();
              int idCorso = Integer.parseInt(request.getParameter("idCourse"));
                ArrayList<Account> presence = PresenceManager.getInstance().getPresenceDottorandi(idCorso);
                JSONArray resultArray = new JSONArray(presence);
                result.put("presence", resultArray);
                out.write(result.toString());
            } catch (SQLException | JSONException ex) {
                Logger.getLogger(GetPresenceDottorandiServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IdException ex) {
             Logger.getLogger(GetPresenceDottorandiServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(GetPresenceDottorandiServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    
     

