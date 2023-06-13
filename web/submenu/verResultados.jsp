<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ver Resultados</title>
<!--    <style>
        table {
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
        }
    </style>-->
</head>
<body>
    <br/>
    
    <h1>Resultados</h1>

    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <th>Liga</th>
                <th>Equipo</th>
                <th>PG</th>
                <th>PP</th>
                <th>PE</th>
                <!-- Agrega más encabezados de columna según la estructura de tu archivo -->
            </tr>
        </thead>
        <tbody>
            <%-- Itera sobre los registros del archivo y muestra los datos en la tabla --%>
            <%
                String fileContent = (String) request.getAttribute("fileContent");
                if (fileContent != null && !fileContent.isEmpty()) {
                    String[] lines = fileContent.split("\\r?\\n"); // Dividir el contenido del archivo por saltos de línea

                    for (String line : lines) {
                        String[] fields = line.split(";"); // Dividir cada línea en campos (ajusta el separador según tu archivo)
            %>
            <tr>
                <td>lola</td>
                <td><%= fields[0] %></td>
                <td><%= fields[1] %></td>
                <!-- Agrega más columnas según la estructura de tu archivo -->
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="6">No se encontró contenido</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
