/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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
@WebServlet(name = "MenuPrincipalArbitro", urlPatterns = {"/MenuPrincipalArbitro"})
public class MenuPrincipalArbitro extends HttpServlet {

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
