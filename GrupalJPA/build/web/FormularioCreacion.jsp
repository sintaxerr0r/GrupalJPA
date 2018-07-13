<%-- 
    Document   : FormularioCreacion
    Created on : 12-07-2018, 11:00:15
    Author     : alumnospr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="ServletCreacion">
            <table>
                <tr><td>Nombre:</td><td><input type="text" name="nombre" placeholder="Ingrese nombre"></td></tr>
                <tr><td>Apellido:</td><td><input type="text" name="apellido" placeholder="Ingrese apellido"></td></tr>
                <tr><td>Edad:</td><td><input type="text" name="edad" placeholder="Ingrese edad"></td></tr>
                <tr><td>Sexo:</td><td><input type="text" name="sexo" placeholder="Ingrese sexo"></td></tr>
                <tr><td>ID Ciudad:</td><td><input type="text" name="idciudad" placeholder="Ingrese ID Ciudad"></td></tr>           
            </table>
            <input type="submit" value="AGREGAR PERSONA">
        </form>
    </body>
</html>
