<%-- 
    Dentro de esta pagina jsp tengo el menu lateral e incluyo el contenido que se muestra en el centro. Ese contenido se encuentra dentro de la carpeta submenuAdmin.
    Document   : menuPrincipalAdmin.jsp
    Created on : 22 may 2023, 0:38:30
    Author     : G14
--%>
<%@page import="es.martinsoftware.ligabaloncesto.entities.Usuarios"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <!-- IMPORT BOOTRSAP 5 -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
            />
        <!-- IMPORT GOOGLE ICONS -->
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"
            />
        <style>
            .nav .active {
                border-radius: 0% !important;
                background-color: cadetblue !important;
            }

            .nav-link {
                color: black !important;
            }

            .nav {
                background-color: rgb(225, 225, 225);
                padding-bottom: 98pc;
            }

            .marco {
                background-color: rgb(184, 204, 197);
            }

            .marco2 {
                margin: 20px 20px 0 0;
                text-align: justify;
            }

            .centradoTabla {
                text-align: center;
            }

            .mostrarDatosSesion{
                font-weight: bold ;
                color: teal;
            }

            .desabilitado{
                color: #b8ccc5 !important;
            }
        </style>

        <title>Menu de navegación vertical</title>
    </head>

    <body>
        <div class="centrado_del_nav marco">
            <!-- MENU LATERAL -->
            <div class="d-flex align-items-start">
                <div
                    class="nav flex-column nav-pills me-3"
                    id="v-pills-tab"
                    role="tablist"
                    aria-orientation="vertical"
                    >
                    <button
                        class="nav-link active desabilitado"
                        id="v-pills-usuarios-tab"
                        data-bs-toggle="pill"
                        data-bs-target="#v-pills-usuarios"
                        type="button"
                        role="tab"
                        aria-controls="v-pills-usuarios"
                        aria-selected="true"
                        disabled>
                        Usuarios
                    </button>
                    <button
                        class="nav-link desabilitado"
                        id="v-pills-ligas-tab"
                        data-bs-toggle="pill"
                        data-bs-target="#v-pills-ligas"
                        type="button"
                        role="tab"
                        aria-controls="v-pills-ligas"
                        aria-selected="false"
                        disabled
                        >
                        Ligas
                    </button>
                    <button
                        class="nav-link"
                        id="v-pills-datos-tab"
                        data-bs-toggle="pill"
                        data-bs-target="#v-pills-datos"
                        type="button"
                        role="tab"
                        aria-controls="v-pills-datos"
                        aria-selected="false"
                        >
                        Cargar Datos
                    </button>
                    <button
                        class="nav-link"
                        id="v-pills-resultados-tab"
                        data-bs-toggle="pill"
                        data-bs-target="#v-pills-resultados"
                        type="button"
                        role="tab"
                        aria-controls="v-pills-resultados"
                        aria-selected="false"
                        >
                        Ver resultados
                    </button>
                    <hr/>
                    <button
                        class="nav-link"
                        id="v-pills-cerrar-tab"
                        data-bs-toggle="pill"
                        data-bs-target="#v-pills-cerrar"
                        type="button"
                        role="tab"
                        aria-controls="v-pills-cerrar"
                        aria-selected="false"
                        >
                        <span>Estas logueado como:
                            <br/>
                             <span class="mostrarDatosSesion"><%= ((Usuarios) session.getAttribute("usuario")).getNombre()%></span>
                        </span>
                        <br/>
                        Cerrar sesión
                    </button>
                </div>

                <!-- CONTENIDO -->
                <div class="marco2">
                    <div class="tab-content" id="v-pills-tabContent">


                        <div
                            class="tab-pane fade"
                            id="v-pills-ligas"
                            role="tabpanel"
                            aria-labelledby="v-pills-ligas-tab">
                            <%--<jsp:include page="/submenu/ligas.jsp" />--%>
                        </div>


                        <div
                            class="tab-pane fade"
                            id="v-pills-datos"
                            role="tabpanel"
                            aria-labelledby="v-pills-datos-tab">
                            <jsp:include page="/submenu/cargarDatos.jsp" />    
                        </div>
                        <div
                            class="tab-pane fade"
                            id="v-pills-resultados"
                            role="tabpanel"
                            aria-labelledby="v-pills-resultados-tab">
                            <jsp:include page="/submenu/resultados.jsp" />
                            <jsp:include page="/submenu/graficas.jsp" />

                        </div>
                        <div
                            class="tab-pane fade"
                            id="v-pills-cerrar"
                            role="tabpanel"
                            aria-labelledby="v-pills-cerrar-tab">
                            <%@include file="/submenu/cerrarSesion.jsp" %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"
        ></script>
    </body>
</html>

