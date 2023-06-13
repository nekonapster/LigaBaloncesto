/*
La clase DAO con PATRON SINGLETON solo se creara la instancia una sola vez. 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.martinsoftware.ligabaloncesto.modelos.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author martin
 */
public class Dao {

//Metodos para EntityManagerFactor
    private static EntityManagerFactory emfEquipos;
    private static EntityManagerFactory emfEstadisticas;
    private static EntityManagerFactory emfJornadas;
    private static EntityManagerFactory emfLigas;
    private static EntityManagerFactory emfPartidos;
    private static EntityManagerFactory emfUsuarios;

//Atributos para JpaController
    private static EquiposJpaController eqjcEquipos;
    private static EstadisticasJpaController esjcEstadisticas;
    private static JornadasJpaController jjcJornadas;
    private static LigasJpaController ljcLigas;
    private static PartidosJpaController pjcPartidos;
    private static UsuariosJpaController ujcUsuarios;

    //PATRON SINGLETON terminarlo
    public static synchronized EquiposJpaController getEquiposJpaController() {
        if (emfEquipos == null) {
            emfEquipos = Persistence.createEntityManagerFactory("LigaBaloncestoPU");
        }
        if (eqjcEquipos == null) {
            eqjcEquipos = new EquiposJpaController(emfEquipos);
        }
        return eqjcEquipos;
    }
    
    public static synchronized EstadisticasJpaController getEstadisticasJpaController() {
        if (emfEstadisticas == null) {
            emfEstadisticas = Persistence.createEntityManagerFactory("LigaBaloncestoPU");
        }

        if (esjcEstadisticas == null) {
            esjcEstadisticas = new EstadisticasJpaController(emfEstadisticas);
        }

        return esjcEstadisticas;
    }

    public static synchronized JornadasJpaController getJornadasJpaController() {
        if (emfJornadas == null) {
            emfJornadas = Persistence.createEntityManagerFactory("LigaBaloncestoPU");
        }

        if (jjcJornadas == null) {
            jjcJornadas = new JornadasJpaController(emfJornadas);
        }
        return jjcJornadas;
    }

    public static synchronized LigasJpaController getLigasJpaController() {
        if (emfLigas == null) {
            emfLigas = Persistence.createEntityManagerFactory("LigaBaloncestoPU");
        }

        if (ljcLigas == null) {
            ljcLigas = new LigasJpaController(emfLigas);
        }
        return ljcLigas;
    }

    public static synchronized PartidosJpaController getPartidosJpaController() {
        if (emfPartidos == null) {
            emfPartidos = Persistence.createEntityManagerFactory("LigaBaloncestoPU");
        }

        if (pjcPartidos == null) {
            pjcPartidos = new PartidosJpaController(emfPartidos);
        }
        return pjcPartidos;

    }

    public static synchronized UsuariosJpaController getUsuariosJpaController() {
        if (emfUsuarios == null) {
            emfUsuarios = Persistence.createEntityManagerFactory("LigaBaloncestoPU");
        }

        if (ujcUsuarios == null) {
            ujcUsuarios = new UsuariosJpaController(emfUsuarios);
        }
        return ujcUsuarios;

    }

}
