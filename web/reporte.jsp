<%-- 
    Document   : reporte
    Created on : 31/10/2012, 11:09:56 PM
    Author     : Tyrips
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte</title>
        <link rel ="stylesheet" type="text/css" href="http://www.ic-itcr.ac.cr/~cazofeifa/PEA/Estilos/esreporte.css"/>
	<script type="text/javascript">
		function salir(){
                    window.location.replace("index.jsp");
		}
	</script>
    </head>
    </head>
    <body>
        <h2>Informe de Evento Acad&eacutemico</h2>
	<input type="image" src="http://www.ic-itcr.ac.cr/~cazofeifa/PEA/Img/salir.png" id="btn_cerrar" onclick="salir()"/>
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
        <div id="financiamiento">
            <fieldset id="fld_financiamiento">
                <legend id="lgd_datosgenerales">Financiamiento</legend>
                <table id="tablafinanciamiento" >
                    <tr >
                        <td></td>
                        <td></td>
                        <td ><label id="lbresolucion" h>Seg&uacuten Resoluci&oacuten/Oficio</label></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="chkcombecas"></td>
                        <td><label id="lbcomitebecas">Comite de Becas</label></td>
                        <td>asdasd</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="chkdirproyectos"></td>
                        <td><label id="lbdirproyectos">Dirección de Proyectos</label></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="chkvie"></td>
                        <td><label id="lbvie">Vicerrectoria de Investigaci&oacuten y Extenci&oacuten</label></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="chkescuelaadmi"></td>
                        <td><label id="lbescuelaadmi">Escuela de Administraci&oacuten de Empresas</label></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="chkvicedocencia"></td>
                        <td><label id="lbvicerrectoriadocencia">Vicerrectoria de Docencia</label></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="chkotro"></td>
                        <td><label id="lbotro">Otros Indique.</label></td>
                    </tr>
                </table>               
            </fieldset>    
        </div>    
        
	<div id="datosgenerales">
            <fieldset id="fld_datosgenerales">
		<legend id="lgd_datosgenerales">Datos Generales</legend>
		<input type="image" src="http://www.ic-itcr.ac.cr/~cazofeifa/PEA/Img/guardar.png" id="btn_guardar"/><br/>
		<label id="lb_objetivos">Objetivos de Participaci&oacute;n:</label></br>
		<textarea id="txt_objetivos" name="txt_objetivos"> </textarea> <br/>
		<label id="lb_objetivos">Principales logros obtenidos y aportes en beneficio de la Escuela y del Tecnol&oacute;gico de Costa Rica:</label></br>
		<textarea id="txt_logros" name="txt_logros"> </textarea> <br/>
		<label id="lb_objetivos">Dificultades e inconvenientes que se presentaron durante el evento:</label></br>
		<textarea id="txt_dificultades" name="txt_dificultades"> </textarea> <br/>                
                <label id="lb_objetivos">Conclusiones:</label></br>
		<textarea id="txt_conclusiones" name="txt_conclusiones"> </textarea> <br/>
                <label id="lb_objetivos">Cualquier otra informac&oacuten que considere pertinente:</label></br>
		<textarea id="txt_otros" name="txt_otros"> </textarea> <br/>
		<label id="lb_objetivos">Documentos relevantes:</label></br>
		<button type="button" id="btn_cronograma">Adjuntar Cronograma</button>
		<button type="button" id="btn_otros">Adjuntar otros...</button>
                <input type="image" src="http://www.ic-itcr.ac.cr/~cazofeifa/PEA/Img/send.png" id="btn_enviar"/>
            </fieldset>
	</div>
    </body>
</html>
