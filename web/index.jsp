<%-- 
    Document   : index
    Created on : Oct 30, 2012, 10:17:34 PM
    Author     : Emendoza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Sesión</title>
        <link rel ="stylesheet" type="text/css" href="http://www.ic-itcr.ac.cr/~emendoza/ad/estilos/eslogin.css"/>
    </head>
    <body>
        <div id="banner">
            <img src="http://www.ic-itcr.ac.cr/~emendoza/ad/imagenes/Logotec_mod.png"/>
	</div>
        <div id="principal">
            <h2 id="t1">Escuela de Administraci&oacute;n de Empresas</h2>
            <div id="img_edificio">
                <img src="http://www.ic-itcr.ac.cr/~emendoza/ad/imagenes/inicio.jpg"/>
            </div>
            <h2 id="t2">Participaci&oacute;n Eventos Acad&eacute;micos</h2>
                <form method="post" action="P_usuario">
                    <label id="lb_usuario">Usuario:</label>
                    <input type="text" name="inpt_usuario" id="inpt_usuario"/><br/>
                    <label id="lb_contrasenna">Contrseña:</label>
                    <input type="password" name="inpt_contrasenna" id="inpt_contrasenna"/><br/>
                    <input type="submit" id="btn_inicio" value="Iniciar Sesión"/>
                </form>
            <div id="mensaje_error">
                <p>El usuario o contraseña introducidos no son correctos</p>
            </div>
        </div>
    </body>
</html>
