package servlet;

import domaine.Avion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eleve
 */
public class ServletAvion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        PrintWriter out = response.getWriter();
        out.println( "bonjour");
        ArrayList<Avion> array = new ArrayList();
        try {
            array = ServiceAvion.getAvions();
        }
        catch (SQLException e) {
           System.out.println(e.getMessage());
        }
        request.setAttribute("avions",array);
        request.setAttribute("login",ServletConnection.login);
        this.getServletContext().getRequestDispatcher( "/avions.jsp" ).forward( request, response );     
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);    
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
