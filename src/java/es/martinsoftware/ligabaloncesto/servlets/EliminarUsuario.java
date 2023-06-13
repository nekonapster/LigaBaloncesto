/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package es.martinsoftware.ligabaloncesto.servlets;

import es.martinsoftware.ligabaloncesto.entities.Equipos;
import es.martinsoftware.ligabaloncesto.entities.Ligas;
import es.martinsoftware.ligabaloncesto.entities.Usuarios;
import es.martinsoftware.ligabaloncesto.modelos.dao.Dao;
import es.martinsoftware.ligabaloncesto.modelos.dao.EquiposJpaController;
import es.martinsoftware.ligabaloncesto.modelos.dao.LigasJpaController;
import es.martinsoftware.ligabaloncesto.modelos.dao.UsuariosJpaController;
import es.martinsoftware.ligabaloncesto.modelos.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author martin
 */
@WebServlet(name = "EliminarUsuario", urlPatterns = {"/EliminarUsuario"})
public class EliminarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        UsuariosJpaController ujc = Dao.getUsuariosJpaController();
        List<Usuarios> usuarios = ujc.findUsuariosEntities();
        request.setAttribute("usuarios", usuarios);

        LigasJpaController ljc = Dao.getLigasJpaController();
        List<Ligas> ligas = ljc.findLigasEntities();
        request.setAttribute("ligas", ligas);

        EquiposJpaController ejc = Dao.getEquiposJpaController();
        List<Equipos> equipos = ejc.findEquiposEntities();
        request.setAttribute("equipos", equipos);
        request.getRequestDispatcher("/menuPrincipalAdmin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsuariosJpaController ujc = Dao.getUsuariosJpaController();
      

            LigasJpaController ljc = Dao.getLigasJpaController();
            List<Ligas> ligas = ljc.findLigasEntities();
            request.setAttribute("ligas", ligas);

            EquiposJpaController ejc = Dao.getEquiposJpaController();
            List<Equipos> equipos = ejc.findEquiposEntities();
            request.setAttribute("equipos", equipos);


            // Obtener el ID del usuario a eliminar desde la solicitud
            String usuarioId = request.getParameter("idAEliminar");

            // Convertir el string obtenido a int para poder usar el destroy
            int idUsuario = Integer.parseInt(usuarioId);

            if (idUsuario != 1) {
                // Eliminar el usuario de la base de datos
                ujc.destroy(idUsuario);

            } else {
                String errorDeEliminacion = "No se puede eliminar al administrador principal";
                request.setAttribute("errorDeEliminacion", errorDeEliminacion);
            }

            // Obtener la lista actualizada de usuarios después de la eliminación
            List<Usuarios> usuarios = ujc.findUsuariosEntities();

            // Actualizar el atributo "usuarios" en la solicitud con la lista actualizada
            request.setAttribute("usuarios", usuarios);

            // Redirigir a la página JSP para mostrar la lista actualizada
            request.getRequestDispatcher("/menuPrincipalAdmin.jsp").forward(request, response);

        } catch (NonexistentEntityException | IOException | NumberFormatException e) {
            e.printStackTrace();

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
