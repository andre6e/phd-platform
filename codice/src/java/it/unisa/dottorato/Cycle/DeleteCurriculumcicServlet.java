package it.unisa.dottorato.Cycle;


import it.unisa.dottorato.exception.NameException;
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
import org.json.JSONException;
import org.json.JSONObject;

/**Servlet incaricata ad effettuare la richiesta di cancellazione di 
 * una coppia curriculum-ciclo (curriculumucic) dato il nome e il numero
 *
 * @author Tommaso Minichiello
 */
@WebServlet(name = "DeleteCurriculumcic", urlPatterns = {"/DeleteCurriculumcic"})
public class DeleteCurriculumcicServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods
     * 
     *
     * @param request oggetto request per accedere ai parametri inviati attraverso
     * il metodo getParameter per ottenere il numero del ciclo <code>number</code> 
     * e il nome del curriculum <code>name</code> per effettuare la cancellazione di 
     * una coppia curriculum-ciclo
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws it.unisa.dottorato.exception.NameException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NameException, Exception {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        try {

            JSONObject result = new JSONObject();
            int number = Integer.parseInt(request.getParameter("number"));
            String name = request.getParameter("name");
            
            result.put("result", true);

            try {
                CycleManager.getInstance().deleteCurriculumcic(number, name);
            } catch (ClassNotFoundException | SQLException ex) {
                result.put("result", false);
                Logger.getLogger(DeleteCurriculumcicServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            out.write(result.toString());

        } catch (JSONException ex) {
            Logger.getLogger(DeleteCurriculumcicServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            out.close();
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(DeleteCurriculumcicServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(DeleteCurriculumcicServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
