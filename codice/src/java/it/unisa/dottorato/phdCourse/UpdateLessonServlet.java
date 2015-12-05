/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.dottorato.phdCourse;

//import it.unisa.integrazione.model.Person;
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
 * @author Giuseppe Picciocchi
 */
@WebServlet(name = "UpdateLessonServlet", urlPatterns = {"/UpdateLessonServlet"})
public class UpdateLessonServlet extends HttpServlet {

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

                int lessonID = Integer.parseInt("" + request.getSession().getAttribute("idLesson"));
                String date = request.getParameter("data");
                String starttime = request.getParameter("starttime");
                String endtime = request.getParameter("endtime");
                String name = request.getParameter("name");
                String classroom = request.getParameter("classroom");
                String description = request.getParameter("description");
                String cycle = request.getParameter("cycle");
                String curriculum = request.getParameter("curriculum");
                String course = request.getParameter("course");

           //    HttpSession session = request.getSession();
             //   Person loggedPerson = (Person) session.getAttribute("person");

                Lesson lesson = new Lesson();

                lesson.setDate(java.sql.Date.valueOf(date));
                lesson.setStartTime(Integer.parseInt(starttime));
                lesson.setEndTime(Integer.parseInt(endtime));
                lesson.setName(name);
                lesson.setClassroom(classroom);
                lesson.setDescription(description);
                lesson.setCycle(Integer.parseInt(cycle));
                lesson.setCurriculum(curriculum);
                lesson.setFK_course(Integer.parseInt(course));

                CalendarManager.getInstance().update_lesson(lessonID, lesson);
                result.put("result", true);

                out.println("<script type=\"text/javascript\">");
                out.println("alert('La lezione è stata modificata');");
                out.println("location='collaborationActivity.jsp';"); // da modificare la locazione
                out.println("</script>");
            } catch (SQLException ex) {
                Logger.getLogger(UpdateLessonServlet.class.getName()).log(Level.SEVERE, null, ex);
                result.put("result", false);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UpdateLessonServlet.class.getName()).log(Level.SEVERE, null, ex);
            } 
            out.write(result.toString());

        } catch (JSONException ex) {
            Logger.getLogger(UpdateLessonServlet.class.getName()).log(Level.SEVERE, null, ex);
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
