/*
Clase de pruebas que hicimos con Amieva para crear ligas. 
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
@WebServlet(name = "CrearLiga", urlPatterns = {"/CrearLiga"})
public class CrearLiga extends HttpServlet {

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
        // Codigo para mostrar usuarios en el menuPrincipalAdmin.jsp.
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

        request.getRequestDispatcher("/menuPrincipalAdmin.jsp").forward(request, response);
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
        // Obtener la lista de usuarios existentes
        UsuariosJpaController ujc = Dao.getUsuariosJpaController();
        List<Usuarios> usuarios = ujc.findUsuariosEntities();

        //PRIMERO instanciamos una persistencia para poder manejar los datos desde y hacia la BD.
        LigasJpaController ljc = Dao.getLigasJpaController();

        //SEGUNDO recupero el nombre de la liga que viene del formulario liga.jsp
        String ligaDelFormulario = request.getParameter("nombreLigaDelFormulario");

        // Obtener la lista de ligas actualizada desde la base de datos
        List<Ligas> ligas = ljc.findLigasEntities();

        try {

            //CREAR
            //Con create podremos almacenar nuevas ligas. se le pasa por parametros un null porque en este caso el id lo pone de manera automatica y entre comillas en nombre que le queremos dar a la liga.
            Ligas ligaActual = new Ligas(null, ligaDelFormulario);
            ljc.create(ligaActual);

            // Guardo la liga en la sesión
            request.getSession().setAttribute("ligaActual", ligaActual);

            //Con findLigasEntitties recuperamos todas las ligas en BD.
            ligas = ljc.findLigasEntities();
            request.setAttribute("ligas", ligas);
            request.setAttribute("usuarios", usuarios);

            request.getRequestDispatcher("/menuPrincipalAdmin.jsp").forward(request, response);

        } catch (Exception e) {
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
