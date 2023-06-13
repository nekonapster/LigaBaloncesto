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
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//FALLO, VENGO DE CREAR EQUIPOS PERO NO SOY CAPAZ DE MOSTRAR LOS EQUIPOS POR
//DEFECTO SIN LA NECESIDAD DE DARLE AL BOTON CREAR
/**
 *
 * @author martin
 */
@WebServlet(name = "ConfiguracionDeLiga", urlPatterns = {"/ConfiguracionDeLiga"})
public class ConfiguracionDeLiga extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //si en la sesion existe una liga creada la meto en "ligaActual"
        Ligas ligaActual = (Ligas) request.getSession().getAttribute("ligaActual");
      
        //captura el nombre del equipo del formulario de equipos.jsp
        String equipoFormulario = request.getParameter("nombreEquipoDelFormulario");

        try {
            EquiposJpaController ejc = Dao.getEquiposJpaController();

            // Crea un nuevo equipo y lo agrega a la base de datos
            Equipos equipoCreado = new Equipos(null, equipoFormulario);
            equipoCreado.setIdLiga(ligaActual);
            ejc.create(equipoCreado);

            // Actualiza la liga actual en la base de datos
            LigasJpaController ljc = Dao.getLigasJpaController();
            ligaActual.getEquiposList().add(equipoCreado);

            
            // Obtiene las listas de usuarios, ligas y equipos actualizadas y las envía a la vista
            UsuariosJpaController ujc = Dao.getUsuariosJpaController();
            List<Usuarios> usuarios = ujc.findUsuariosEntities();
            request.setAttribute("usuarios", usuarios);

            List<Ligas> ligas = ljc.findLigasEntities();
            //con el reques se guardan los datos para enviarlos luego, esta linea no almacena nada en la BD
            request.setAttribute("ligas", ligas);

            List<Equipos> equiposActualizados = ejc.findEquiposEntities();
            request.setAttribute("equipos", equiposActualizados);
        } catch (Exception ex) {
            Logger.getLogger(ConfiguracionDeLiga.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher("/menuPrincipalAdmin.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
