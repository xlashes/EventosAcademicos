<%-- 
    Document   : solicitud
    Created on : Oct 31, 2012, 1:46:56 AM
    Author     : Emendoza, Cazofeifa
GIT: Subversion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%     
     String usuario = (String)session.getAttribute("usuario");
     String nombre = (String)session.getAttribute("nombre");
     String apellidos = (String)session.getAttribute("apellidos");
     String titulo = (String)session.getAttribute("titulo");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitud</title>
        <link rel ="stylesheet" type="text/css" href="http://www.ic-itcr.ac.cr/~cazofeifa/PEA/Estilos/essolicitud.css"/>
	<script type="text/javascript">
		function salir(){
                    //Invalida la sesion
                    <% session.invalidate();%>
                    //Sobreescribe el historial para no permitir darle atras
                    window.location.replace("index.jsp");
		}
                function enviar(){
                    document.formulario.submit();
                }
	</script>
    </head>
    <body>        
    	<h2>Formulario de Solicitud de Participación en Evento</h2>       
        <input type="image" src="http://www.ic-itcr.ac.cr/~cazofeifa/PEA/Img/salir.png" id="btn_cerrar" onclick="salir()" />
        <form method="post" action="EnviarSolicitud" name="formulario">
        <label id="lb_cerrarsesion" onclick="salir()">Cerrar sesión <i><%=usuario%></i></label>	
	<div id="datospersonales">
		<fieldset>                   
			<legend id="lgd_datospersonales">Datos Personales</legend>
                        <br><br>
			<label id="lb_nombre">Nombre:</label>
                        <input type="text" id="inpt_nombre" value="<%=nombre %>" disabled="disabled"/><br/>
			<label id="lb_apellidos">Apellidos:</label>
			<input type="text" id="inpt_apellidos" value="<%=apellidos%>" disabled="disabled"/><br/>
			<label id="lb_titulo" >Titulo acad&eacute;mico:</label>
			<input type="text" id="inpt_titulo" value ="<%=titulo%>" disabled="disabled"/><br/>
			<label id="lb_participacion">Tipo de participaci&oacute;n:</label>
			<select name="slct_participacion"/>
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
                <br><br>
		<label id="lb_nombreevento">Nombre:</label>
		<input type="text" name="inpt_nombreevento" id="inpt_nombreevento"/><br/>
		<label id="lb_lugar">Lugar:</label>
		<input type="text" name="inpt_lugar" id="inpt_lugar"/><br/>
		<label id="lb_org">Organizador:</label>
		<input type="text" name="inpt_org" id="inpt_org"/><br/>
		<label id="lb_finiciodd">Fecha Inicio:</label>
		<input type="text" name="inpt_inicio" id="inpt_inicio" maxlength="2"/>
		<label id="lb_fechadd">dd</label>
                <input type="text" name="inpt_inicio" id="inpt_inicio" maxlength="2"/>
		<label id="lb_fechamm">mm</label>
                <input type="text" name="inpt_inicio" id="inpt_inicio" maxlength="4"/>
		<label id="lb_fechaaa">aa</label><br/>
		<label id="lb_fin">Fecha Fin:</label>                         
                <input type="text" name="inpt_fin" id="inpt_fin" maxlength="2"/>
		<label id="lb_fechadd">dd</label>
                <input type="text" name="inpt_fin" id="inpt_fin" maxlength="2"/>
		<label id="lb_fechamm">mm</label>
                <input type="text" name="inpt_fin" id="inpt_fin" maxlength="4"/>
		<label id="lb_fechaaa">aa</label><br/>
            </fieldset>
	</div>
	<div id="datosgenerales">
            
            <fieldset id="fld_datosgenerales">
		<legend id="lgd_datosgenerales">Datos Generales</legend>
		<input type="image" src="http://www.ic-itcr.ac.cr/~cazofeifa/PEA/Img/guardar.png" id="btn_guardar"/><br/>
		<label id="lb_objetivos">Objetivos de Participaci&oacute;n:</label></br>
		<textarea id="txt_objetivos" name="txt_objetivos"> </textarea> <br/>
		<label id="lb_objetivos">Logros esperados y aportes en beneficio de la Escuela y del Tecnol&oacute;gico de Costa Rica:</label></br>
		<textarea id="txt_logros" name="txt_logros"> </textarea> <br/>
		<label id="lb_objetivos">Cualquier otra informaci&oacute;n que considere pertinente:</label></br>
		<textarea id="txt_otros" name="txt_otros"> </textarea> <br/>
		<label id="lb_objetivos">Documentos relevantes:</label></br>
		<button type="button" id="btn_cronograma">Adjuntar Cronograma</button>
		<button type="button" id="btn_otros">Adjuntar otros...</button>
                <input type="image" src="http://www.ic-itcr.ac.cr/~cazofeifa/PEA/Img/send.png" id="btn_enviar"/>
            </fieldset>
	</div>
        </form>>
    </body>
</html>
