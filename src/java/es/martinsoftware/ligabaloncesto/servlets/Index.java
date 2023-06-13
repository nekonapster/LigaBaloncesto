package es.martinsoftware.ligabaloncesto.servlets;

import es.martinsoftware.ligabaloncesto.entities.Usuarios;
import es.martinsoftware.ligabaloncesto.modelos.dao.Dao;
import es.martinsoftware.ligabaloncesto.modelos.dao.UsuariosJpaController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String pass = request.getParameter("pass");

        // Consultar la base de datos para verificar el usuario
        UsuariosJpaController ujc = Dao.getUsuariosJpaController();
        List<Usuarios> usuarios = ujc.findUsuariosEntities();
        Usuarios usuario = null;

        for (Usuarios u : usuarios) {
            if (u.getNombre().equals(nombre) && u.getPass().equals(pass)) {
                usuario = u;
                break;
            }
        }

        if (usuario != null) {
            String rol = usuario.getRol();
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            switch (rol) {
                case "administrador" -> response.sendRedirect("/LigaBaloncesto/MenuPrincipalAdmin");
                case "arbitro" -> response.sendRedirect("/LigaBaloncesto/MenuPrincipalArbitro");
                default -> {
                    // Rol no reconocido, redirigir a una página de error o mostrar un mensaje de error
                    request.setAttribute("error", "Algo falló, volver a intentarlo.");
                    request.getRequestDispatcher("/errorSesion.jsp").forward(request, response);
                }
            }
        } else {
            // Mostrar mensaje de error y volver a mostrar el formulario de inicio de sesión
            request.setAttribute("error", "Nombre de usuario o contraseña incorrectos");
            request.getRequestDispatcher("/errorSesion.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
