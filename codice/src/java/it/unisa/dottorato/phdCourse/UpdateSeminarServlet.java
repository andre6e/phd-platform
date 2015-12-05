/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.dottorato.phdCourse;

import it.unisa.dottorato.account.Professor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author Giuseppe
 */
@WebServlet(name = "UpdateSeminarServlet", urlPatterns = {"/UpdateSeminarServlet"})
public class UpdateSeminarServlet extends HttpServlet {

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

        JSONObject result = new JSONObject();
        PrintWriter out = response.getWriter();

        try {
            try {
                response.setContentType("text/html;charset=UTF-8");

                int seminarID = Integer.parseInt("" + request.getSession().getAttribute("idSeminar"));
                String date = request.getParameter("data");
                String starttime = request.getParameter("starttime");
                String endtime = request.getParameter("endtime");
                String name = request.getParameter("name");
                String namespeacker = request.getParameter("namespeacker");
                String description = request.getParameter("description");
                String place = request.getParameter("place");
                String course = request.getParameter("course");

                HttpSession session = request.getSession();
                Professor loggedPerson = (Professor) session.getAttribute("person");

                Seminar seminar = new Seminar();

                //inseriamo nell'oggetto corso i valori passati come parametri precedentemente
                seminar.setDate(java.sql.Date.valueOf(date));
                seminar.setStartTime(Integer.parseInt(starttime));
                seminar.setEndTime(Integer.parseInt(endtime));
                seminar.setName(name);
                seminar.setNameSpeacker(namespeacker);
                seminar.setDescription(description);
                seminar.setPlace((place));
                seminar.setFK_course(Integer.parseInt(course));

                CalendarManager.getInstance().update_seminar(seminarID, seminar);
                result.put("result", true);

                out.println("<script type=\"text/javascript\">");
                out.println("alert('Il seminario è stato modificato');");
                out.println("location='collaborationActivity.jsp';"); // da modificare la locazione
                out.println("</script>");
            } catch (SQLException ex) {
                Logger.getLogger(UpdateSeminarServlet.class.getName()).log(Level.SEVERE, null, ex);
                result.put("result", false);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UpdateSeminarServlet.class.getName()).log(Level.SEVERE, null, ex);
            } 
            out.write(result.toString());

        } catch (JSONException ex) {
            Logger.getLogger(UpdateSeminarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
