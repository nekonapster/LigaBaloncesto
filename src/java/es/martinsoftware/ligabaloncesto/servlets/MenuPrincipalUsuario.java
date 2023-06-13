/*
servlet MenuPrincipalUsuario, controla la llegada del administrador, perimitiendole crear mas administradores u arbitros. Aparte de crear ligas y generear jornadas. 
 */
package es.martinsoftware.ligabaloncesto.servlets;

import es.martinsoftware.ligabaloncesto.entities.Partidos;
import es.martinsoftware.ligabaloncesto.modelos.dao.Dao;
import es.martinsoftware.ligabaloncesto.modelos.dao.PartidosJpaController;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author G14
 */
@WebServlet(name = "MenuPrincipalUsuario", urlPatterns = {"/MenuPrincipalUsuario"})
public class MenuPrincipalUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Codigo para mostrar equipos en el menuPrincipalAdmin.jsp.
        PartidosJpaController pjc = Dao.getPartidosJpaController();

        List<Partidos> listaPartido = pjc.findPartidosEntities();

        request.setAttribute("listaPartido", listaPartido);
        request.getRequestDispatcher("/Grafica").include(request, response);
        request.getRequestDispatcher("/menuPrincipalUsuario.jsp").forward(request, response);

//        
//        HttpSession session = request.getSession();
//        if (session != null) {
//            //cuando voy del controlador a la vista usar el forward!!!!!!!!!
//            response.sendRedirect("/menuPrincipalUsuario.jsp");
//            return;
//        } else {
//            // La sesión no existe o ha expirado, redirigir a la página de inicio.html
//            response.sendRedirect(LIT_VIEW_LOGIN);
//            return;
//        }
    }

}
