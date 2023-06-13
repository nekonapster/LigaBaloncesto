<%-- 
    Document   : cargarDatos.jsp
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
            .errorMensajeEliminacionAdminPrincipal .errorMensajeCreacionAdminPrincipal{
                padding: 7px;
                background-color: teal;
            }
            #cargaTodo{
                appearance: none;
                border: none;
                background-color: teal;
                color: white;
                padding: 7px;
            }
            .celdaEliminar{
                background-color: teal !important;
                text-align: center;
            }
        </style>


        <title>JSP Page</title>
    </head>


    <body>
        <form method="POST" action="CargarFichero" enctype="multipart/form-data">
            <div class="input-group mb-3">
                <input type="file" name="archivo" class="form-control" id="inputGroupFile02" required="">
                <button type="submit" class="input-group-text" for="inputGroupFile02">Cargar</button>
            </div>
        </form>

        <table class="table table-sm table-striped table-hover">
            <thead class="table-dark ">
                <tr>
                    <td class="liga-column">Fecha</td>
                    <td class="liga-column">Local</td>
                    <td class="liga-column">Visitante</td>
                    <td class="liga-column">Puntos local</td>
                    <td class="liga-column"   colspan="2">Puntos visitante</td>
                    <!--<td colspan="2" style="text-align: center">Opciones</td>-->
                </tr>
            </thead>
            <tbody>

                <c:forEach var="ListaDePartido" items="${listaPartido}">
                    <tr>
                <form action="CargarDatos" method="POST">

                    <td>
                        <fmt:formatDate  value="${ListaDePartido.fecha}" pattern="dd/MM/yyyy" />
                    </td>
                    <td>${ListaDePartido.idLocal.nombre}</td>
                    <td>
                        <input 
                            class="formatoCeldaLocal form-control form-control-sm"
                            type="number" 
                            name="PuntosLocal" 
                            value="${puntosEquipoLocal}" 
                            min="0" 
                            style="width:50px;" 
                            oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
                            maxlength = "3" 
                            >
                    </td>

                    <td>${ListaDePartido.idVisitante.nombre}</td>
                    <td>
                        <input 
                            class="formatoCeldaVisitante form-control form-control-sm"
                            type="number" 
                            name="PuntosVisitante" 
                            value="${puntosEquipoVisitante}" 
                            min="0" 
                            style="width:50px;" 
                            oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);"
                            maxlength = "3"
                            >
                    </td>

                    <td class="celdaEliminar">
                        <input type="hidden" name="idPartido" value="${ListaDePartido.id}">
                        <input class="btnEliminar" type="submit" value="CargarDatos">
                    </td>
                </form>
            </tr>
        </c:forEach>
    </tbody>
</table>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        // Hacer todos los botones de carga de datos invisibles
        $(".btnEliminar").hide();

        // Añade un nuevo botón para cargar todos los datos
        $("#botonDiv").append('<button id="cargaTodo" type="button">Carga todos los datos</button>');

        // Cuando se presiona el nuevo botón, se envían todos los formularios usando AJAX
        $("#cargaTodo").click(function (e) {
            e.preventDefault();

            let ajaxCalls = [];

            $("form").each(function () {
                let form = $(this);
                let ajaxCall = $.ajax({
                    type: form.attr('method'),
                    url: form.attr('action'),
                    data: form.serialize()
                });

                ajaxCalls.push(ajaxCall);
            });

            $.when.apply($, ajaxCalls).always(function () {
                alert("Los datos se han cargado correctamente");
                location.reload();
            });
        });
    });
</script>



<div id="botonDiv"></div>


</body>
</html>
