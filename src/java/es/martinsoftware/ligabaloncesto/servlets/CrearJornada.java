/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
import es.martinsoftware.ligabaloncesto.modelos.exceptions.NonexistentEntityException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

@WebServlet(name = "CrearJornada", urlPatterns = {"/CrearJornada"})
public class CrearJornada extends HttpServlet {

    private int numeroJornada = 1;

//
    public List<Equipos> generamosListaPar(List<Equipos> listaEquipos, Ligas liga) {
        int n = listaEquipos.size();
        // Se verifica si el tamaño de la lista es impar
        if (n % 2 != 0) {
            // Si es impar, se elimina el último elemento de la lista para que el tamaño sea par
            EquiposJpaController ejc = Dao.getEquiposJpaController();

            Equipos equipoFantasma = new Equipos();
            equipoFantasma.setNombre("Equipo Fantasma");
            equipoFantasma.setIdLiga(liga);
            ejc.create(equipoFantasma);
            listaEquipos.add(equipoFantasma);
        }
        // Se retorna la lista de equipos
        return listaEquipos;
    }

    private List<Partidos> crearaJornadas(Date fechaJornada, Jornadas jornadas, boolean visitanteBul) throws ParseException {

        // Se crea un nuevo controlador de equipos.
        EquiposJpaController ejc = Dao.getEquiposJpaController();

        // Se obtienen todos los equipos existentes en la base de datos y se almacenan en una lista.
        List<Equipos> equiposEnBd = generamosListaPar(ejc.findEquiposEntities(), jornadas.getIdLiga());

        List<Partidos> partidosDeLaJornada = new ArrayList<Partidos>();

        List<Equipos> local = equiposEnBd.subList(0, equiposEnBd.size() / 2);
        List<Equipos> visitante = equiposEnBd.subList(equiposEnBd.size() / 2, equiposEnBd.size());

//        int equipoSize = equiposEnBd.size();
        if (!visitanteBul) {

            // Primera vuelta
            System.out.println("Partido de ida");
            for (int i = 0; i < local.size(); i++) {
                System.out.println("Jornada No: " + numeroJornada++);
//                for (int j = 0; j < equipoSize ; j++) {
                System.out.println("Local: " + local.get(i).getNombre() + " - Visitante: " + visitante.get(i).getNombre());
                Partidos partido = new Partidos();
                partido.setFecha(fechaJornada);
                partido.setIdLocal(local.get(i));
                partido.setIdVisitante(visitante.get(i));
                partido.setIdJornada(jornadas);
                partidosDeLaJornada.add(partido);
//                }
                System.out.println("---------------------------------------");
            }
        } else {

            // Segunda vuelta
            System.out.println("Partido de vuelta");
            for (int i = 0; i < visitante.size(); i++) {
                System.out.println("Jornada No: " + numeroJornada++);
                System.out.println("Local: " + visitante.get(i).getNombre() + " - Visitante: " + local.get(i).getNombre());
                Partidos partido = new Partidos();
                partido.setFecha(fechaJornada);
                partido.setIdLocal(visitante.get(i));
                partido.setIdVisitante(local.get(i));
                partido.setIdJornada(jornadas);
                partidosDeLaJornada.add(partido);
//                }
                System.out.println("---------------------------------------");
            }
        }
        return partidosDeLaJornada;
    }

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

        try {

            request.setAttribute("listaPartido", null);

            // Asigna la lista de fechas formateadas al atributo 'fechasFormateadas' del objeto request.
            request.setAttribute("fechasFormateadas", null);

            // Asigna la lista de ligas al atributo 'ligas' del objeto request.
            request.setAttribute("ligas", null);

            // Asigna la lista de jornadas al atributo 'jornadas' del objeto request.
            request.setAttribute("jornadas", null);

            // Asigna la lista de equipos al atributo 'equipos' del objeto request.
            request.setAttribute("equipos", null);

            //capturamos la fecha que viene como String y la convertimos en un DATE para poder enviarla a la BD.        
            String fechaDelFormulario = request.getParameter("fechaDesdeJornada");
            Date fecha = new SimpleDateFormat("yy-MM-dd").parse(fechaDelFormulario);

//----------Conecto con la BD---------------------------------------------------
            // Se crea un controlador JPA para la entidad 'Jornadas'. Esto permite realizar operaciones en la base de datos relacionadas con las jornadas.
            JornadasJpaController jjc = Dao.getJornadasJpaController();

            // Se crea un controlador JPA para la entidad 'Ligas'. Esto permite realizar operaciones en la base de datos relacionadas con las ligas.
            LigasJpaController ljc = Dao.getLigasJpaController();

            // Se crea un controlador JPA para la entidad 'Equipos'. Esto permite realizar operaciones en la base de datos relacionadas con los equipos.
            EquiposJpaController ejc = Dao.getEquiposJpaController();

//------------------------------------------------------------------------------
            UsuariosJpaController ujc = Dao.getUsuariosJpaController();
            List<Usuarios> usuarios = ujc.findUsuariosEntities();

            // Utiliza el controlador JPA de Jornadas para encontrar todas las entidades Jornadas en la base de datos y las guarda en una lista.
            List<Jornadas> jornadas = jjc.findJornadasEntities();

            // Utiliza el controlador JPA de Equipos para encontrar todas las entidades Equipos en la base de datos y las guarda en una lista.
            List<Equipos> equipos = ejc.findEquiposEntities();

            // Utiliza el controlador JPA de Ligas para encontrar todas las entidades Ligas en la base de datos y las guarda en una lista.
            List<Ligas> ligas = ljc.findLigasEntities();

            // Obtiene el atributo 'ligaActual' de la sesión HTTP actual y lo almacena como un objeto Ligas. 
            // Esto supone que este atributo ha sido previamente establecido en algún punto durante la sesión del usuario.
            Ligas ligaActual = (Ligas) request.getSession().getAttribute("ligaActual");

//            //creo un obejo y le paso por parametros lo que me requiera en la bd. salvo la FK de liga
            Jornadas jornadaCreada = new Jornadas(null, numeroJornada, fecha);
//            //a la jornadaCreada le seteo la liga y por parametro le paso la liga de la sesion o cualquier otra incluso alguna que envie por formulario con un gettParametter.
            jornadaCreada.setIdLiga(ligaActual);
//
//            //recupero la lista y añado nueva jornada. 
            ligaActual.getJornadasList().add(jornadaCreada);

//----------FORMATEO DE FECHA Y ENVIO AL JSP------------------------------------
            // Define el formato de la fecha que quieres usar
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

            // Crea una lista de Strings para almacenar las fechas formateadas
            List<String> fechasFormateadas = new ArrayList<>();

            Date fechaOrigen = fecha;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaOrigen);

            PartidosJpaController pjc = Dao.getPartidosJpaController();

            // Itera a través de todas las jornadas
            Boolean visitante = false;
            List<Equipos> equiposFor = generamosListaPar(ligaActual.getEquiposList(), ligaActual);
            for (int i = 0; i < equiposFor.size() / 2; i++) {
                Jornadas j = new Jornadas();
                j.setFecha(fecha);
                j.setIdLiga(ligaActual);
                j.setNumero(numeroJornada);

                if (j.getPartidosList() == null) {
                    jjc.create(j);
                    Date fechaJornada = calendar.getTime();
                    // Convierte la fecha de cada jornada al formato deseado
                    String fechaFormateada = df.format(fechaJornada);
                    // Añade la fecha formateada a la lista
                    fechasFormateadas.add(fechaFormateada);
                    List<Partidos> partidosJornada = crearaJornadas(fechaJornada, j, visitante);
                    j.setPartidosList(partidosJornada);
                    for (Partidos p : j.getPartidosList()) {
                        p.setIdLiga(ligaActual);
                        p.setIdJornada(j);
                        pjc.create(p);
                    }
                    try {
                        jjc.edit(j);
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(CrearJornada.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(CrearJornada.class.getName()).log(Level.SEVERE, null, ex);

                    }
                    calendar.add(Calendar.WEEK_OF_YEAR, 1);
                    visitante = !visitante;
                }
            }

            jornadas = jjc.findJornadasEntities();

            // Asigna la lista de fechas formateadas al atributo 'fechasFormateadas' del objeto request.
            request.setAttribute("fechasFormateadas", fechasFormateadas);

            // Asigna la lista de ligas al atributo 'ligas' del objeto request.
            request.setAttribute("ligas", ligas);

            // Asigna la lista de jornadas al atributo 'jornadas' del objeto request.
            request.setAttribute("jornadas", jornadas);

            // Asigna la lista de equipos al atributo 'equipos' del objeto request.
            request.setAttribute("equipos", equipos);

            List<Partidos> partido = pjc.findPartidosEntities();

            request.setAttribute("listaPartido", partido);
            
            request.setAttribute("usuarios", usuarios);
            
            // Reenvía la solicitud y la respuesta al archivo JSP 'menuPrincipalAdmin.jsp' para su procesamiento posterior
            request.getRequestDispatcher("/menuPrincipalAdmin.jsp").forward(request, response);

        } catch (ParseException e) {
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
