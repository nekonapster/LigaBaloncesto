<%-- 
    Document   : comodin
    Created on : 27 may 2023, 19:53:40
    Author     : G14
--%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="if" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- jsp ligas de administrador -->
        <p>En este apartado podremos crear las ligas:</p>

        <!--<form method="POST" action="ConfiguracionDeLiga">-->
        <form method="POST" action="CrearLiga">
            <input type="text" name="nombreLigaDelFormulario" placeholder="nombre de la liga" />
            <input type="submit" value="Crear"/>
        </form>

        <br/>
        <table>

            <c:forEach var="liga" items="${ligas}">
                <tr>
                    <td>
                        <c:forEach var="equipo" items="${liga.equiposList}">
                            ${equipo.nombre}<br>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>

        </table>

    </body>
</html>
