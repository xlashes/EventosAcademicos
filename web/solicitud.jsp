<%-- 
    Document   : solicitud
    Created on : Oct 31, 2012, 1:46:56 AM
    Author     : Emendoza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%     
     String codigo = (String)session.getAttribute("cod");
     String nombre = (String)session.getAttribute("nom");
     String contrasena = (String)session.getAttribute("cont");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitud</title>
        <link rel ="stylesheet" type="text/css" href="http://www.ic-itcr.ac.cr/~emendoza/ad/estilos/essolicitud.css"/>
	<script type="text/javascript">
		function salir(){
                    window.location.replace("index.jsp");
		}
	</script>
    </head>
    <body>
    	<h2>Formulario de Solicitud de Participación en Evento</h2>
	<input type="image" src="http://www.ic-itcr.ac.cr/~emendoza/ad/imagenes/salir.png" id="btn_cerrar" onclick="salir()"/>
	<div id="datospersonales">
		<fieldset>
			<legend id="lgd_datospersonales">Datos Personales</legend>
			<label id="lb_nombre">Nombre:</label>
			<input type="text" id="inpt_nombre"/><br/>
			<label id="lb_apellidos">Apellidos:</label>
			<input type="text" id="inpt_apellidos"/><br/>
			<label id="lb_titulo">Titulo acad&eacute;mico:</label>
			<input type="text" id="inpt_titulo"/><br/>
			<label id="lb_participacion">Tipo de participaci&oacute;n:</label>
			<select id="slct_participacion"/>
                            <option value="0">Participante</option>
                            <option value="1">Ponente</option>
                            <option value="2">Invitado</option>
                            <option value="3">otro</option>
			</select>
			<button type="button" id="btn_datospersonales">Adjuntar Documento</button>
		</fieldset>
	</div>
	<div id="datosevento">
            <fieldset>
		<legend id="lgd_datosevento">Datos Evento</legend>
		<label id="lb_nombreevento">Nombre:</label>
		<input type="text" id="inpt_nombreevento"/><br/>
		<label id="lb_lugar">Lugar:</label>
		<input type="text" id="inpt_lugar"/><br/>
		<label id="lb_org">Organizador:</label>
		<input type="text" id="inpt_org"/><br/>
		<label id="lb_inicio">Fecha inicio:</label>
		<input type="text" id="inpt_inicio"/>
		<label id="lb_fecha1">ddmmyy</label><br/>
		<label id="lb_fin">Fecha Fin:</label>
		<input type="text" id="inpt_fin"/><label id="lb_fecha2">ddmmyy</label><br/>
            </fieldset>
	</div>
	<div id="datosgenerales">
            <fieldset id="fld_datosgenerales">
		<legend id="lgd_datosgenerales">Datos Generales</legend>
		<input type="image" src="http://www.ic-itcr.ac.cr/~emendoza/ad/imagenes/guardar.png" id="btn_guardar"/><br/>
		<label id="lb_objetivos">Objetivos de Participaci&oacute;n:</label></br>
		<textarea id="txt_objetivos" name="tar"> </textarea> <br/>
		<label id="lb_objetivos">Logros esperados y aportes en beneficio de la Escuela y del Tecnol&oacute;gico de Costa Rica:</label></br>
		<textarea id="txt_logros" name="tar"> </textarea> <br/>
		<label id="lb_objetivos">Cualquier otra informaci&oacute;n que considere pertinente:</label></br>
		<textarea id="txt_otros" name="tar"> </textarea> <br/>
		<label id="lb_objetivos">Documentos relevantes:</label></br>
		<button type="button" id="btn_cronograma">Adjuntar Cronograma</button>
		<button type="button" id="btn_otros">Adjuntar otros...</button>
                <input type="image" src="http://www.ic-itcr.ac.cr/~emendoza/ad/imagenes/send.png" id="btn_enviar"/>
            </fieldset>
	</div>
    </body>
</html>
