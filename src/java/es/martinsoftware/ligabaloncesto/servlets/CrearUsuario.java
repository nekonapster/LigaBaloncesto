/*
CrearUsuario.java Servlet para la creacion y eliminacion de usuarios
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
@WebServlet(name = "CrearUsuario", urlPatterns = {"/CrearUsuario"})
public class CrearUsuario extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener la lista de usuarios existentes
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

//       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LigasJpaController ljc = Dao.getLigasJpaController();
        List<Ligas> ligas = ljc.findLigasEntities();
        EquiposJpaController ejc = Dao.getEquiposJpaController();
        List<Equipos> equipos = ejc.findEquiposEntities();
        UsuariosJpaController ujc = Dao.getUsuariosJpaController();
        // Obtén los valores enviados desde el formulario
        String usuarioNombre = request.getParameter("creacionNombreDesdeAdmin");
        String usuarioEmail = request.getParameter("creacionEmailDesdeAdmin");
        String usuarioPass = request.getParameter("creacionPassDesdeAdmin");
        String usuarioRol = request.getParameter("creacionRolDesdeAdmin");
        // Obtener la lista de usuarios actualizada desde la base de datos
        List<Usuarios> usuarios = ujc.findUsuariosEntities();
        boolean nombreExiste = false;
        // Verificar si el nombre de usuario ya existe en la base de datos
        for (Usuarios usuario : usuarios) {
            if (usuario.getNombre().equals(usuarioNombre)) {
                nombreExiste = true;
                break;
            }
        }
        if (nombreExiste) {
            String errorDeCreacion = "No se puede crear el usuario. El nombre de usuario ya está en uso.";
            request.setAttribute("errorDeCreacion", errorDeCreacion);
        } else {
            // Crear el usuario en la base de datos
            ujc.create(new Usuarios(null, usuarioNombre, usuarioEmail,
                    usuarioPass, usuarioRol));
        }
        // Obtener la lista de usuarios actualizada
        usuarios = ujc.findUsuariosEntities();
        request.setAttribute("ligas", ligas);
        request.setAttribute("equipos", equipos);
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/menuPrincipalAdmin.jsp").forward(request, response);
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
