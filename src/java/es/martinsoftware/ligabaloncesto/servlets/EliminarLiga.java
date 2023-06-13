package es.martinsoftware.ligabaloncesto.servlets;

import es.martinsoftware.ligabaloncesto.entities.Equipos;
import es.martinsoftware.ligabaloncesto.entities.Jornadas;
import es.martinsoftware.ligabaloncesto.entities.Ligas;
import es.martinsoftware.ligabaloncesto.entities.Usuarios;
import es.martinsoftware.ligabaloncesto.modelos.dao.Dao;
import es.martinsoftware.ligabaloncesto.modelos.dao.EquiposJpaController;
import es.martinsoftware.ligabaloncesto.modelos.dao.JornadasJpaController;
import es.martinsoftware.ligabaloncesto.modelos.dao.LigasJpaController;
import es.martinsoftware.ligabaloncesto.modelos.dao.UsuariosJpaController;
import es.martinsoftware.ligabaloncesto.modelos.exceptions.IllegalOrphanException;
import es.martinsoftware.ligabaloncesto.modelos.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EliminarLiga", urlPatterns = {"/EliminarLiga"})
public class EliminarLiga extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/menuPrincipalAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuariosJpaController ujc = Dao.getUsuariosJpaController();
            LigasJpaController ljc = Dao.getLigasJpaController();
            EquiposJpaController ejc = Dao.getEquiposJpaController();
            JornadasJpaController jjc = Dao.getJornadasJpaController();
            String ligaId = request.getParameter("idAEliminar");
            int idLiga = Integer.parseInt(ligaId);

            if (idLiga != 1) {
                // Eliminar equipos
                List<Equipos> equiposAsociados = ljc.findLigas(idLiga).getEquiposList();
                if (!equiposAsociados.isEmpty()) {
                    for (Equipos equipo : equiposAsociados) {
                        ejc.destroy(equipo.getId());
                    }
                }
                // Eliminar jornadas
                List<Jornadas> jornadasAsociadas = ljc.findLigas(idLiga).getJornadasList();
                if (!jornadasAsociadas.isEmpty()) {
                    for (Jornadas jornada : jornadasAsociadas) {
                        jjc.destroy(jornada.getId());
                    }
                }
                // Finalmente eliminar la liga
                ljc.destroy(idLiga);
            }

            List<Usuarios> usuarios = ujc.findUsuariosEntities();
            List<Equipos> equipos = ejc.findEquiposEntities();
            List<Ligas> ligas = ljc.findLigasEntities();
            request.setAttribute("usuarios", usuarios);
            request.setAttribute("equipos", equipos);
            request.setAttribute("ligas", ligas);
            request.getRequestDispatcher("/menuPrincipalAdmin.jsp").forward(request, response);

        } catch (NonexistentEntityException | IOException | NumberFormatException e) {
            e.printStackTrace();
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(EliminarLiga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
