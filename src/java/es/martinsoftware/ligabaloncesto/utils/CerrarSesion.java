/*
CerrarSesion es un servlet encargado de elimar la sesion que estuviera abierta y redirije a sesionCerrada.jsp. 
 */
package es.martinsoftware.ligabaloncesto.utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author martin
 */
@WebServlet(name = "CerrarSesion", urlPatterns = {"/CerrarSesion"})
public class CerrarSesion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //instanciamos una sesion llamada session
        //HttpSession session = request.getSession(false);
        HttpSession session = request.getSession();

        //comprobamos [si la sesion no es nula, entonces invalidate (cerrala)] y redirigimos a una pagina jsp para mostrar el mensaje que la sesion fue cerrada. 
        if (session != null) {
            session.invalidate();
            String vista= "/sesionCerrada.jsp";
            getServletContext().getRequestDispatcher(vista).forward(request, response);
          
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
