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
            .liga-column {
                width: 500px;  /* Ancho columna tabla */
            }
        </style>

    </head>
    <body>
        <!-- Muestra el nombre de la liga actual -->
        <h5>Liga actual: ${ligaActual.nombre}</h5>
        <!--<form method="POST" action="ConfiguracionDeLiga">-->
        <form method="POST" action="CrearLiga">
            <input type="text" name="nombreLigaDelFormulario" placeholder="nombre de la liga" required />
            <input type="submit" value="Crear"/>
        </form>

        <br />

        <br/>

        <table class="table table-sm table-striped table-hover">
            <thead class="table-dark ">
                <tr>
                    <td class="liga-column">Nombre de la liga</td>
                    <td colspan="2" style="text-align: center">Opciones</td>
                </tr>
            </thead>
            <tbody>
                <!--MUESTRO LO QUE ME TRAIGO DE LA TABLA USUARIOS DE LA BD -->
                <c:forEach var="liga" items="${ligas}">
                    <tr>
                        <td>${liga.nombre}</td>
                        <!--features-->
                        <!--<td class="celdaEditar"><a class="linkEditar" href="modalEditar">Editar</a></td>-->
                        <td class="celdaEliminar">
                            <form action="EliminarLiga" method="POST" onsubmit="return confirm('Esta acción tambien eliminara a todos los equipos y las jornadas asociados a esta liga, ¿deseas continuar?');">
                                <input type="hidden" name="idAEliminar" value="${liga.id}">
                                <input class="btnEliminar" type="submit" value="Eliminar">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
