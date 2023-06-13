<%-- 
    Document   : partidos
    Created on : 4 jun 2023, 17:25:11
    Author     : G14
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="if" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <style>
            .fecha-column .local-column .visitante-column .puntosL-column .puntosV-column {
                width: auto ;  /* Ancho columna tabla */
            }
        </style>

    </head>
    <body>
        <table class="table table-sm table-striped table-hover">
            <thead class="table-dark ">
                <tr>
                    <td class="fecha-column">Fecha</td>
                    <td class="local-column">Local</td>
                    <td class="visitante-column">Visitante</td>
                    <td class="puntosL-column">Puntos local</td>
                    <td class="puntosV-column">Puntos visitante</td>
                    <td colspan="2" style="text-align: center">Opciones</td>
                </tr>
            </thead>
            <tbody>
                <!--MUESTRO LO QUE ME TRAIGO DE LA TABLA USUARIOS DE LA BD -->
              
                <c:forEach var="ListaDePartido" items="${listaPartido}">
                    <tr>
                        <td>
                            <fmt:formatDate  value="${ListaDePartido.fecha}" pattern="dd/MM/yyyy" />
                        </td>
                        <td>${ListaDePartido.idLocal.nombre}</td>
                        <td>${ListaDePartido.idVisitante.nombre}</td>
                        <td>${ListaDePartido.puntosLocal}</td>
                        <td>${ListaDePartido.puntosVisitante}</td>
                        <!--features-->
                        <!--<td class="celdaEditar"><a class="linkEditar" href="modalEditar">Editar</a></td>-->
                        <td class="celdaEliminar">
                            <form action="EliminarPartido" method="POST" >
                                <input type="hidden" name="idAEliminar" value="${ListaDePartido.id}">
                                <input class="btnEliminar" type="submit" value="Eliminar">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
