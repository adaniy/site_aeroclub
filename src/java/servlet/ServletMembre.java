package servlet;

import domaine.Membre;
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
public class ServletMembre extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        PrintWriter out = response.getWriter();
        out.println( "bonjour");
      //  String toto=ServletConnection.login;
      //  System.out.println(ServletConnection.login);
        ArrayList<Membre> array = new ArrayList();
      
        try {
              if (ServletConnection.droit==1) {
                array = ServiceMembre.getMoi();
              }
              else if (ServletConnection.droit==2){
                array = ServiceMembre.getMembres();  
              }
              else {
                array = ServiceMembre.getMembres();
              }
        }
        catch (SQLException e) {
           System.out.println(e.getMessage());
        }
        request.setAttribute("membres",array);
        this.getServletContext().getRequestDispatcher( "/membre.jsp" ).forward( request, response );     
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
