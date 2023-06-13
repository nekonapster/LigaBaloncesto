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
        <style>
            .equipo-column {
                width: auto;  /* Ancho columna tabla */
            }
        </style>


    </head>
    <body>
        <form method="POST" action="ConfiguracionDeLiga">
            <input type="text" name="nombreEquipoDelFormulario" placeholder="nombre del equipo" required autofocus/>
            <input type="submit" value="Crear" />
        </form>
        <br/>
        <table class="table table-sm table-striped table-hover">
            <thead class="table-dark">
                <tr>
                    <td class="equipo-column">Nombre del equipo</td>
                    <td colspan="2" style="text-align: center">Opciones</td>
                </tr>
            </thead>
            <tbody>
                <!--MUESTRO LO QUE ME TRAIGO DE LA TABLA USUARIOS DE LA BD -->
                <c:forEach var="equipo" items="${equipos}">
                    <tr>
                        <td>${equipo.nombre}</td>
                        <td class="celdaEliminar" >
                            <form action="EliminarEquipo" method="POST">
                                <input type="hidden" name="idAEliminar" value=${equipo.id}>
                                <input class="btnEliminar" type="submit" value="Eliminar">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>