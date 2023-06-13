/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package es.martinsoftware.ligabaloncesto.servlets;

import es.martinsoftware.ligabaloncesto.entities.Equipos;
import es.martinsoftware.ligabaloncesto.entities.Ligas;
import es.martinsoftware.ligabaloncesto.entities.Partidos;
import es.martinsoftware.ligabaloncesto.entities.Usuarios;
import es.martinsoftware.ligabaloncesto.modelos.dao.Dao;
import es.martinsoftware.ligabaloncesto.modelos.dao.EquiposJpaController;
import es.martinsoftware.ligabaloncesto.modelos.dao.LigasJpaController;
import es.martinsoftware.ligabaloncesto.modelos.dao.PartidosJpaController;
import es.martinsoftware.ligabaloncesto.modelos.dao.UsuariosJpaController;
import es.martinsoftware.ligabaloncesto.modelos.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author G14
 */
@WebServlet(name = "EliminarPartido", urlPatterns = {"/EliminarPartido"})
public class EliminarPartido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

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
        processRequest(request, response);
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
        processRequest(request, response);

        LigasJpaController ljc = Dao.getLigasJpaController();
        UsuariosJpaController ujc = Dao.getUsuariosJpaController();
        EquiposJpaController ejc = Dao.getEquiposJpaController();
        PartidosJpaController pjc = Dao.getPartidosJpaController();

        String equipoId = request.getParameter("idAEliminar");
        int idEquipo = Integer.parseInt(equipoId);

        try {
            pjc.destroy(idEquipo);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EliminarPartido.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Ligas> ligas = ljc.findLigasEntities();
        List<Usuarios> usuarios = ujc.findUsuariosEntities();
        List<Equipos> equipos = ejc.findEquiposEntities();
        List<Partidos> partidos = pjc.findPartidosEntities();
        request.setAttribute("ligas", ligas);
        request.setAttribute("usuarios", usuarios);
        request.setAttribute("equipos", equipos);
        request.setAttribute("partidos", partidos);
        
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
