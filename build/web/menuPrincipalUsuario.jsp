<%-- 
    Dentro de esta pagina jsp tengo el menu lateral e incluyo el contenido que se muestra en el centro. Ese contenido se encuentra dentro de la carpeta submenuAdmin.
    Document   : menuPrincipalUsuario.jsp
    Created on : 22 may 2023, 0:38:30
    Author     : G14
--%>
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


            .volver{
                appearance: none;
                border: none;
                background: teal;
                color: white;
                padding: 7px 60px;
                margin: 0xp
            }

            .imprimir{
                appearance: none;
                border: none;
                background: teal;
                color: white;
                padding: 7px 60px;
                margin: 0xp
            }
        </style>

        <title>Menu de navegación vertical</title>
    </head>

    <body class="body">
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
                        class="nav-link active"
                        id="v-pills-resultados-tab "
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

                    <div>
                        <a href="index.html"><input class="volver" type="button" value="Volver"></a>
                    </div>
                </div>

                <!-- CONTENIDO -->
                <div class="marco2">
                    <div class="tab-content" id="v-pills-tabContent">
                        <div
                            class="tab-pane fade show active"
                            id="v-pills-resultados"
                            role="tabpanel"
                            aria-labelledby="v-pills-resultados-tab">
                            <jsp:include page="/submenu/resultados.jsp" />
                            <jsp:include page="/submenu/graficas.jsp" />

                        </div>
                        <input class="imprimir printbutton" type="button" value="Imprimir" class="printbutton">

                    </div>
                </div>
            </div>
        </div>



        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"
            >
        </script>

        <script >
            document.querySelectorAll('.printbutton').forEach(function (element) {
                element.addEventListener('click', function () {
                  print();
                });
            });
        </script>
    </body>
</html>

