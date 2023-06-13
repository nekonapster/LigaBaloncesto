<%-- 
    Pagina de error con posibilidad de redirigir a index.html
    Document   : errorPage.jsp
    Created on : 15 may 2023, 18:31:48
    Author     : martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- IMPORT BOOTSTRAP 5 -->
        <%@include file="boostrapHead.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <div style="text-align:center">
            </br>
            </br>
            <h1>PÁGINA DE ERROR</h1>
            <h2>Lo sentimos pero algo falló!</h2>
            <h3>Vuele a intentarlo.</h3>
            <img src="IMG/error.svg" alt="calavera"/>
            </br>
            </br>
            <a href="index.html"><- Volver</a>
        </div>



        <!-- IMPORT BOOTSTRAP 5 -->
        <%@include file="bootstrapBody.jsp" %>
    </body>
</html>
