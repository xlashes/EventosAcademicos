/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * mas
 */
package Controlador;

import Persistencia.validarUsuario;
import Persistencia.leerHistorialProfesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Emendoza
 */
public class IniciarSesion extends HttpServlet {
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
           //Obtienen variables que son enviadas desde Index.jsp
            String usuario = request.getParameter("inpt_usuario");
            String contra = request.getParameter("inpt_contrasenna");
            
            // Va a la Capa de persistencia para validar el usuario
            int resultado = validarUsuario.consultarUsuario(usuario, contra);

            if(resultado==0){
                //Usuario no esta registrado
                //Muestra mensaje de error
                response.sendRedirect("index_.jsp");
            }
            else{
                if(resultado == 1){
                    //Usuario tipo administrador
                    //Crea sesion
                    HttpSession session = request.getSession(true);
                    //Agregan los obejtos a guardar en session
                    session.setAttribute("nom", usuario);
                    session.setAttribute("cont", contra);
                    //Muestra historial luego de iniciar sesion
                    response.sendRedirect("historialAdmin.jsp");
                }
                else if(resultado == 2){
                    //Usuario tipo profesor
                    //Va a capa de persistencia a obtener historial del usuario
                    ArrayList<String[]> historial = leerHistorialProfesor.obtenerhistorialProfesor(usuario);
                    //Crea sesion
                    HttpSession session = request.getSession(true);
                    //Agregan los obejtos a guardar en session
                    session.setAttribute("nom", usuario);
                    session.setAttribute("historial",historial);
                   /* out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet NewServlet</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>"+ usuario+ "</h1>");
                    for(int i =0;i<historial.size();i++){
                        out.println("<p>"+ historial.get(i)[0]+"," +historial.get(i)[1]+","+historial.get(i)[2]+","+ historial.get(i)[3] +"</p>");
                    }
                    out.println("</body>");
                    out.println("</html>");*/
                    //Muestra historial luego de iniciar sesion
                    response.sendRedirect("historialProfesor.jsp");
                }
                else{
                    //nulo
                }
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