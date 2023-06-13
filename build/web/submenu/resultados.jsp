<%-- 
    Document   : resultados
    Created on : 5 jun 2023, 9:15:19
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

    </head>
    <body>
        <table class="table table-sm table-striped table-hover">
            <thead class="table-dark ">
                <tr>
                    <td class="liga-column">Fecha</td>
                    <td class="liga-column">Local</td>
                    <td class="liga-column">Visitante</td>
                    <td class="liga-column">Puntos local</td>
                    <td class="liga-column">Puntos visitante</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ListaDePartido" items="${listaPartido}">
                    <tr>
                        <td>
                            <fmt:formatDate  value="${ListaDePartido.fecha}" pattern="dd/MM/yyyy" />
                        </td>
                        <td>${ListaDePartido.idLocal.nombre}</td>
                        <td>${ListaDePartido.puntosLocal}</td>

                        <td>${ListaDePartido.idVisitante.nombre}</td>
                        <td>${ListaDePartido.puntosVisitante}
                        </td>
                    </tr>
                </c:forEach>
        </table>
    </body>
</html>
