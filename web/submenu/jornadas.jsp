

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="if" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .jornada-column {
                width: 200px;  /* Ancho columna tabla */
            }
        </style>

    </head>
    <body>

        <!-- jsp jornadas de administrador -->
        <p>Establece la fecha inicial para generar Jornadas:</p>

        <form method="POST" action="CrearJornada" onsubmit="return confirm('Por favor, ten en cuenta que si has ingresado un número impar de equipos, el sistema creara automáticamente un equipo fantasma para mantener un número par. Este paso es necesario para poder generar las jornadas de manera eficiente. ¿deseas continuar?');">
            <input type="date" name="fechaDesdeJornada" required/>
            <input type="submit" value="Crear" />
        </form>

        <br />
        <br/>
        <table class="table table-sm table-striped table-hover">
            <thead class="table-dark">
                <tr>
                    <td class="jornada-column">Número de la jornada</td>
                    <td>Fecha</td>
                    <td colspan="2" style="text-align: center">Opciones</td>
                </tr>
            </thead>
            <tbody>
                <!-- MUESTRO LO QUE ME TRAIGO DE LA TABLA JORNADAS DE LA BD -->
                <c:forEach var="jornada" items="${jornadas}" varStatus="status">
                    <tr>
                        <td>${jornada.numero}</td>
                        <td>${fechasFormateadas[status.index]}</td> <!-- Accedemos a la fecha formateada correspondiente -->
                        <td class="celdaEliminar">
                            <form action="EliminarJornada" method="POST">
                                <input type="hidden" name="idAEliminar" value="${jornada.id}">
                                <input class="btnEliminar" type="submit" value="Eliminar">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
