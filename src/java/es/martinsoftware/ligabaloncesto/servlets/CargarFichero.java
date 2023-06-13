package es.martinsoftware.ligabaloncesto.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "CargarFichero", urlPatterns = {"/CargarFichero"})
@MultipartConfig
public class CargarFichero extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("archivo");
        InputStream is = part.getInputStream();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line;
            int cont = 0;
            while ((line = reader.readLine()) != null) {
                
                //si la linea leida es vacia, ignorarla y seguir. 
                if (line.isEmpty()) {
                    continue;
                }
                switch (cont) {
                    case 0:
                        //recojo el numero de la jornada convertir en entero.
                        String numeroJornada = line.split(" ")[1].trim();
                        //pasar jornada a int.

                        //
                        break;
                    default:
                        String[] equipos = line.split("-");
                        String[] local = equipos[0].split(":");
//                        recojo el nombre del equipo local
                        String equipoLocal = local[0].trim();
//                        recojo los puntos del equipo visitante pasar los puntos a int
                        String puntosEquipoLocal = local[1].trim();

                        String[] visitantes = equipos[1].split(":");
//                        recojo el nombre del equipo visitante
                        String equipoVisitante = visitantes[0].trim();
//                        recojo los puntos del equipo visitante, pasar los puntos a int
                        String puntosEquipoVisitante = visitantes[1].trim();
//                  

                        System.out.println("-------------------");
                        System.out.println(puntosEquipoLocal);
                        System.out.println(puntosEquipoVisitante);
                }

                cont++;
            }

        }

    }

//    private String getFileName(Part part) {
//        String contentDisposition = part.getHeader("content-disposition");
//        String[] tokens = contentDisposition.split(";");
//        for (String token : tokens) {
//            if (token.trim().startsWith("filename")) {
//                return token.substring(token.indexOf("=") + 2, token.length() - 1);
//            }
//        }
//        return "";
//    }
}
