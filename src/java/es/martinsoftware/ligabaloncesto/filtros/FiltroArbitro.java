/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.martinsoftware.ligabaloncesto.filtros;

import es.martinsoftware.ligabaloncesto.entities.Usuarios;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author G14
 */
public class FiltroArbitro {

    @WebFilter("/MenuPrincipalArbitro")
    public static class AuthenticationFilter implements Filter {

        public AuthenticationFilter() {
            super();
        }

        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession session = req.getSession();

            Usuarios usuario = (Usuarios) session.getAttribute("usuario");

            boolean isArbitro = (usuario != null && "arbitro".equals(usuario.getRol()));

            if (usuario == null) {
               res.sendRedirect("index.html");
            } else if (isArbitro) {
                // Si el usuario es arbitro, permite que la solicitud continue
                chain.doFilter(request, response);
            } else {
                // Si el usuario no es arbitro, redirige a la página de inicio de sesión.
                res.sendRedirect("index.html");
            }
        }
    }
}
