<%-- 
EJEMPLO DE LIBRERIA CHART.JS
    Document   : graficas
    Created on : 28 may 2023, 12:46:22
    Author     : G14
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- cambiamos los estilos del fondo-->

<style>
    .canvasBg{
        /*background: white;*/
    }
</style>


<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- IMPORT CHART.JS -->
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

        <script>
            var datos = [
                    //status tiene varios atributos y uno de ellos si es el ultimo. 
            <c:forEach var="numero" items="${lista}" varStatus="status">
                ${numero}
            //sino es la ultima linea a todas las anteriores metele una coma. 
                <c:if test="${!status.last}">
            ,
                </c:if>
            </c:forEach>
            ];
        </script>

        <title>Gráfica</title>
    </head>


    <body>



        <h3>Gráfica</h3>

        <!-- CREAMOS UN CANVAS -->
        <div class="canvasBg" style="width: 1000px">
            <!-- ASIGNAMOS UN NOMBRE AL ID PARA LUEGO USARLO EN EL SCRIPT -->
            <canvas id="myChart"></canvas>
        </div>

        <script>
            // Recogemos el elemento del DOM con el ID "myChart" y lo asignamos a la constante 'ctx'
            const ctx = document.getElementById("myChart");

            // Creamos un nuevo gráfico utilizando la biblioteca Chart.js
            new Chart(ctx, {
                // Especificamos que queremos un gráfico de barras
                type: "bar",

                data: {
                    // Definimos las etiquetas para los ejes del gráfico
                    labels: ["Red", "Blue", "Yellow"],
                    datasets: [
                        {
                            // Establecemos el título del conjunto de datos
                            label: "# de jugadores totales por liga",
                            // Proporcionamos los datos para el gráfico
                            data: datos,
                            // Establecemos el ancho del borde de las barras
                            borderWidth: 1,
                            //asignamos colores a cada barra
                            backgroundColor: [
                                "rgba(255, 99, 132, 0.5)",
                                "rgba(255, 159, 64, 0.5)",
                                "rgba(255, 205, 86, 0.5)",
                                1
                            ],
                            borderColor: [
                                "rgb(255, 99, 132)",
                                "rgb(255, 159, 64)",
                                "rgb(255, 205, 86)",
                            ],
                        },
                    ],
                },
                options: {
                    scales: {
                        y: {
                            // Aseguramos que el eje Y comienza en cero
                            beginAtZero: true,
                        },
                    },
                    plugins: {
                        tooltip: {
                            callbacks: {
                                label: function (context) {
                                    // Definimos los comentarios personalizados para cada label
                                    var comments = ["Comentario 1", "Comentario 2", "Comentario 3"];
                                    return comments[context.dataIndex];
                                }
                            }
                        }
                    }
                },
            });
        </script>
    </body>
</html>
