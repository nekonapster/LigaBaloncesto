/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.martinsoftware.ligabaloncesto.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author martin
 */
@Entity
@Table(name = "equipos")
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e"),
    @NamedQuery(name = "Equipos.findById", query = "SELECT e FROM Equipos e WHERE e.id = :id"),
    @NamedQuery(name = "Equipos.findByNombre", query = "SELECT e FROM Equipos e WHERE e.nombre = :nombre")})
public class Equipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private List<Estadisticas> estadisticasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLocal")
    private List<Partidos> partidosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVisitante")
    private List<Partidos> partidosList1;
    @JoinColumn(name = "id_liga", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ligas idLiga;

    public Equipos() {
    }

    public Equipos(Integer id) {
        this.id = id;
    }

    public Equipos(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estadisticas> getEstadisticasList() {
        return estadisticasList;
    }

    public void setEstadisticasList(List<Estadisticas> estadisticasList) {
        this.estadisticasList = estadisticasList;
    }

    public List<Partidos> getPartidosList() {
        return partidosList;
    }

    public void setPartidosList(List<Partidos> partidosList) {
        this.partidosList = partidosList;
    }

    public List<Partidos> getPartidosList1() {
        return partidosList1;
    }

    public void setPartidosList1(List<Partidos> partidosList1) {
        this.partidosList1 = partidosList1;
    }

    public Ligas getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(Ligas idLiga) {
        this.idLiga = idLiga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipos)) {
            return false;
        }
        Equipos other = (Equipos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.martinsoftware.ligabaloncesto.entities.Equipos[ id=" + id + " ]" + nombre;
    }
    
}
