<%-- 
    Document   : historialAdmin
    Created on : 01/11/2012, 12:52:55 AM
    Author     : Tyrips
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%     
     //String codigo = (String)session.getAttribute("cod");
     String nombre = (String)session.getAttribute("nom");
     //String contrasena = (String)session.getAttribute("cont");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrador de Eventos</title>
        <link rel ="stylesheet" type="text/css" href="http://www.ic-itcr.ac.cr/~cazofeifa/PEA/Estilos/eshistorialadmin.css"/>
	<script type="text/javascript">
		function salir(){
                    window.location.replace("index.jsp");
		}
	</script>
    </head>
    <body>
        
        <input type="image" src="http://www.ic-itcr.ac.cr/~cazofeifa/PEA/Img/salir.png" id="btn_cerrar" onclick="salir()"/>
        <input type="text" id="inpt_busqueda" value="Haga su búsqueda aqu&iacute"/><br/>
        <input type="checkbox" value="Todos"> <label id="filtrobusquedatodos">Todos</label>
        <input type="radio" id="rad" name="group1" value="Sesión"><label id="filtrobusqueda">Sesión</label>
        <input type="radio" id="rad" name="group1" value="Fecha"><label id="filtrobusqueda">Fecha</label> 
        <input type="radio" id="rad" name="group1" value="Nombre"><label id="filtrobusqueda">Nombre</label> 
        <input type="radio" id="rad" name="group1" value="Evento"><label id="filtrobusqueda">Evento</label>  
        <div id="solicitudes">
		<fieldset>
                    <legend id="lgd_solicitudes">Solicitudes</legend>                 
                    <table id="tablasolicitudes" >
                        <tr>
                            <th><label id="tablasolicitudtitulo">Nombre</label></th>
                            <th><label id="tablasolicitudtitulo">Evento</label></th>
                            <th><label id="tablasolicitudtitulo">Fecha Evento</label></th>
                            <th><label id="tablasolicitudtitulo">Fecha Envío</label></th>
                            <th><label id="tablasolicitudtitulo">Sesi&oacuten</label></th>
                            <th><label id="tablasolicitudtitulo">Estado</label></th>
                            <th></th>
                        </tr>
                    </table>
                </fieldset>
        </div>
        <div id="reportes">
		<fieldset>
                    <legend id="lgd_reportes">Reportes</legend>
                    <table id="tablareportes" >
                        <tr >
                            <th><label id="tablareportetitulo">Nombre</label></th>
                            <th><label id="tablareportetitulo">Evento</label></th>
                            <th><label id="tablareportetitulo">Fecha</label></th>
                            <th><label id="tablareportetitulo">Sesi&oacute;n</label></th>
                            <th><label id="tablareportetitulo">Estado</label></th>
                            <th></th>
                        </tr>                           
                    </table>
                </fieldset>
        </div>
    </body>
</html>
