/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Emendoza
 */
public class P_usuario extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           //Recogemos variables que son enviadas desde Index.jsp
            String usuario = request.getParameter("inpt_usuario");
            String contra = request.getParameter("inpt_contrasenna");
            //popeye
            //Realizamos acceso a base de Datos
            String [] datos=Sql.getFila("SELECT * FROM usuarios WHERE Nombre='" +usuario+"' AND Contrasena='"+contra+"'");

            if(datos==null){
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet P_usuario</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet P_usuario at " + request.getContextPath() + "</h1>");
            out.println("<p>" + datos + "</p>");
            out.println("</body>");
            out.println("</html>");
            }
            else{
                out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet P_usuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet P_usuario entro al else</h1>");
            out.println("<p>" + datos + "</p>");
            out.println("</body>");
            out.println("</html>");
            //Capturamos las variables a mostrar
            String id=datos[0];
            String nombres=datos[1];
            String contrasenna=datos[2];

            //creamos nuestra sesion
            HttpSession session = request.getSession(true);
            //Obtenemos los obejtos a guardar en session
            session.setAttribute("cod", id);
            session.setAttribute("nom", nombres);
            session.setAttribute("cont", contrasenna);
            //pagina a donde se enviara si se encuentra el usuario autenticado
            response.sendRedirect("solicitud.jsp");
            }
        }
        finally {            
           out.close();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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