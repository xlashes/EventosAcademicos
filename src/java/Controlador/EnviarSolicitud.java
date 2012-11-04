/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Persistencia.insertarSolicitud;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emendoza
 */
public class EnviarSolicitud extends HttpServlet {

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
            //Obtienen variables que son enviadas desde solicitud.jsp
            String usuario = request.getParameter("inpt_usuario");
            String tipoParti = request.getParameter("slct_participacion");
            String rutaDoc = "falta";
            String evento = request.getParameter("inpt_nombreevento");
            String lugar = request.getParameter("inpt_lugar");
            String organizador = request.getParameter("inpt_org");
            String fechaIni = request.getParameter("inpt_inicio");
            String fechaFin = request.getParameter("inpt_fin");
            String objetivos = request.getParameter("txt_objetivos");
            String logros = request.getParameter("txt_logros");
            String otros = request.getParameter("txt_otros");
            
            //manda a la capa de persistencia para que inserte en la BD
            int result = insertarSolicitud.almacenarSolicitud(usuario, tipoParti, rutaDoc, evento, lugar, organizador, fechaIni, fechaFin, objetivos, logros, otros);
            
            if(result == 0){
                //Error en la insercion
            }
            else{
                response.sendRedirect("historialProfesor.jsp");
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
