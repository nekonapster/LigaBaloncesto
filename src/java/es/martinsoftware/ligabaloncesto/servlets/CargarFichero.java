package es.martinsoftware.ligabaloncesto.servlets;

import es.martinsoftware.ligabaloncesto.entities.Equipos;
import es.martinsoftware.ligabaloncesto.entities.Jornadas;
import es.martinsoftware.ligabaloncesto.entities.Ligas;
import es.martinsoftware.ligabaloncesto.entities.Partidos;
import es.martinsoftware.ligabaloncesto.entities.Usuarios;
import es.martinsoftware.ligabaloncesto.modelos.dao.Dao;
import es.martinsoftware.ligabaloncesto.modelos.dao.EquiposJpaController;
import es.martinsoftware.ligabaloncesto.modelos.dao.JornadasJpaController;
import es.martinsoftware.ligabaloncesto.modelos.dao.LigasJpaController;
import es.martinsoftware.ligabaloncesto.modelos.dao.PartidosJpaController;
import es.martinsoftware.ligabaloncesto.modelos.dao.UsuariosJpaController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuariosJpaController ujc = Dao.getUsuariosJpaController();
        List<Usuarios> usuarios = ujc.findUsuariosEntities();
        request.setAttribute("usuarios", usuarios);

        // Codigo para mostrar ligas en el menuPrincipalAdmin.jsp.
        LigasJpaController ljc = Dao.getLigasJpaController();
        List<Ligas> ligas = ljc.findLigasEntities();
        request.setAttribute("ligas", ligas);

        // Codigo para mostrar equipos en el menuPrincipalAdmin.jsp.
        EquiposJpaController ejc = Dao.getEquiposJpaController();
        List<Equipos> equipos = ejc.findEquiposEntities();
        request.setAttribute("equipos", equipos);

        // Codigo para mostrar equipos en el menuPrincipalAdmin.jsp.
        JornadasJpaController jjc = Dao.getJornadasJpaController();
        List<Jornadas> jornadas = jjc.findJornadasEntities();
        request.setAttribute("jornadas", jornadas);

        // Codigo para mostrar equipos en el menuPrincipalAdmin.jsp.
        PartidosJpaController pjc = Dao.getPartidosJpaController();
        List<Partidos> partidos = pjc.findPartidosEntities();
        request.setAttribute("listaPartido", partidos);

        List<Partidos> partido = pjc.findPartidosEntities();
        request.setAttribute("partido", partido);

        request.getRequestDispatcher("/Grafica").include(request, response);
        request.getRequestDispatcher("/menuPrincipalArbitro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PartidosJpaController pjc = Dao.getPartidosJpaController();
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
                        request.setAttribute("puntosEquipoLocal", puntosEquipoLocal);
                        request.setAttribute("puntosEquipoVisitante", puntosEquipoVisitante);
                }

                cont++;
            }

            List<Partidos> partido = pjc.findPartidosEntities();
            List<Partidos> listaPartido = pjc.findPartidosEntities();

            request.setAttribute("partido", partido);
            request.setAttribute("listaPartido", listaPartido);
            request.getRequestDispatcher("/menuPrincipalArbitro2.jsp").forward(request, response);
        }
    }
}
