<%-- 
    Document   : historialProfesor
    Created on : 02/11/2012, 06:25:29 PM
    Author     : Tyrips
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%     
     String nombre = (String)session.getAttribute("nom");
     ArrayList<String[]> historial = (ArrayList<String[]>)session.getAttribute("historial");
%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> </title>
        <link rel ="stylesheet" type="text/css" href="http://www.ic-itcr.ac.cr/~cazofeifa/PEA/Estilos/eshistorialprofesor.css"/>
	<script type="text/javascript">
		function salir(){
                    window.location.replace("index.jsp");
		}
	</script>
    </head>
    <body> 
        <h2><%=nombre%></h2>
        <p><% for(int i=0; i<historial.size()-1;i++){
                out.write(historial.get(i)[2].toString());                
        }
            %></p>
        <input type="image" src="http://www.ic-itcr.ac.cr/~cazofeifa/PEA/Img/salir.png" id="btn_cerrar" onclick="salir()"/> 
        <h2 id="lb_historialsolicitud" >Historial de Solicitudes y Reportes de Eventos</h2>
        <br>
        <div id="solicitudes">
        <fieldset>
            <legend id="lgd_solicitudes">Solicitudes Enviadas</legend>                 
            <table id="tablasolicitudes" >
                <tr>                            
                    <th><label id="tablasolicitudtitulo">Evento</label></th>
                    <th><label id="tablasolicitudtitulo">Fecha Evento</label></th>                            
                    <th><label id="tablasolicitudtitulo">Fecha Envío</label></th>                            
                    <th><label id="tablasolicitudtitulo">Estado Solicitud</label></th>
                </tr>                
                <% for(int i=0; i<historial.size();i++) {%>
                    <tr>
                        <td><%=historial.get(i)[0].toString()%></td>
                        <td><%=historial.get(i)[1].toString()%></td>
                        <td><%=historial.get(i)[2].toString()%></td>
                        <td><%=historial.get(i)[3].toString()%></td>                        
                    </tr>
               <%  } %>
            </table>
            <form method="post" action="IniciarLlenadoSolicitud">            
                <input type="hidden" id="inpt_nombre" name="inpt_nombre" value="<%=nombre%>"/>
                <input type="submit" id="btn_nuevaSolicitud" value="Nueva Solicitud"/>
            </form>
        </fieldset>
        </div>
        <div id="reportes">
            <fieldset>
                <legend id="lgd_reportes">Reportes</legend>
                <table id="tablareportes" >
                    <tr>                            
                        <th><label id="tablareportetitulo">Evento</label></th>
                        <th><label id="tablareportetitulo">Fecha</label></th>                            
                        <th><label id="tablareportetitulo">Estado Reporte</label></th>
                        <th></th>
                    </tr>                           
                </table>
            </fieldset>
        </div>
    </body>
</html>
