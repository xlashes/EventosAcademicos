/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Persistencia.leerDatosPersona;
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
public class IniciarLlenadoSolicitud extends HttpServlet {

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
            //Obtiene variables que son enviadas desde historial.jsp
            String usuario = request.getParameter("inpt_nombre"); 
            
            String[] InfoPersona;
            //Manda a capa de persistencia a leer datos del usuario
            InfoPersona = leerDatosPersona.obtenerDatosPersona(usuario);
            
            if(InfoPersona == null){
                //Caso que tenga problemas con la conexion
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Obtuvo los siguientes datos</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Error 500</h1>");
                out.println("<p>Nombre: " + InfoPersona[0] + "</p>");
                out.println("<p>Apellidos: " + InfoPersona[1] + "</p>");
                out.println("<p>Titulo Academico: " + InfoPersona[2] + "</p>");
                out.println("</body>");
                out.println("</html>"); 
            }
            else{
                //Crea una sesion
                HttpSession session = request.getSession(true);
                //Agregan los objetos a guardar en session
                session.setAttribute("usuario",usuario);
                session.setAttribute("nombre", InfoPersona[0]);
                session.setAttribute("apellidos", InfoPersona[1]);
                session.setAttribute("titulo", InfoPersona[2]);
                //Muestra solicitud luego de iniciar sesion
                response.sendRedirect("solicitud.jsp");
            }
                
        } finally {            
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
