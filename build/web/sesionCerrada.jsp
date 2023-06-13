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
            <h1>BYE!</h1>
            <h2>¡Su sesion se ha cerrado correctamente!</h2>
            <img src="IMG/smile.svg" alt="cara sonriente"/>
            </br>
            </br>
            <a href="index.html">Iniciar sesión nuevamente</a>
        </div>

        <!-- IMPORT BOOTSTRAP 5 -->
        <%@include file="bootstrapBody.jsp" %>
    </body>
</html>
