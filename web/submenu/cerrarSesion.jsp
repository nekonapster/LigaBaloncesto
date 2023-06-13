<!-- jsp cerrarSesion de administrador -->
<%-- 
    Document   : cerrarSesion
    Created on : 25 may 2023, 9:51:26
    Author     : martin
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrar sesion</title>

        <style>
            .container {
                text-align: left;
            }

        
            .btn-custom {
                width: 115px ; /* Ancho personalizado */
                border-radius: 0 ;/* Bordes en 0px */
                background-color: teal; /* Color de fondo teal */
                color: white; /* Color del texto en blanco */
                text-decoration: none; /* Sin subrayado en los enlaces */
                display: inline-block; /* Mostrar como un bloque en línea */
                padding: 10px; /* Espacio interno */
                margin: 5px; /* Margen exterior */
                border: none; /* Sin borde */
            }
            .btn-custom:hover {
                background-color: #5f9ea0; /* Color de fondo teal */
            }

        </style>

    </head>
    <body>
        <div class="container">
            <h3><p>Querés cerrar la sesión ?</p></h3>
            <a class="cerrarSesionLinkSi" href="CerrarSesion"><button class="btn-custom">Si</button></a>
            <a class="cerrarSesionLinkNo" href="MenuPrincipalAdmin"><button class="btn-custom">No</button></a>
        </div>   
    </body>
</html>