/*
servlet MenuPrincipalUsuario, controla la llegada del administrador, perimitiendole crear mas administradores u arbitros. Aparte de crear ligas y generear jornadas. 
 */
package es.martinsoftware.ligabaloncesto.servlets;

import static es.martinsoftware.ligabaloncesto.literals.Literals.LIT_VIEW_LOGIN;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author G14
 */
@WebServlet(name = "MenuPrincipalUsuario", urlPatterns = {"/MenuPrincipalUsuario"})
public class MenuPrincipalUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null) {
            //cuando voy del controlador a la vista usar el forward!!!!!!!!!
            response.sendRedirect("./menuPrincipalUsuario.jsp");
            return;
        } else {
            // La sesión no existe o ha expirado, redirigir a la página de inicio.html
            response.sendRedirect(LIT_VIEW_LOGIN);
            return;
        }
    }

}
