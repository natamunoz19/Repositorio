/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kronos16
 */
@Entity
@Table(name = "Usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id"),
    @NamedQuery(name = "Usuarios.findByPeso", query = "SELECT u FROM Usuarios u WHERE u.peso = :peso"),
    @NamedQuery(name = "Usuarios.findByCalAccion", query = "SELECT u FROM Usuarios u WHERE u.calAccion = :calAccion"),
    @NamedQuery(name = "Usuarios.findByCalComedia", query = "SELECT u FROM Usuarios u WHERE u.calComedia = :calComedia"),
    @NamedQuery(name = "Usuarios.findByCalTerror", query = "SELECT u FROM Usuarios u WHERE u.calTerror = :calTerror"),
    @NamedQuery(name = "Usuarios.findByCalAnimada", query = "SELECT u FROM Usuarios u WHERE u.calAnimada = :calAnimada"),
    @NamedQuery(name = "Usuarios.findByCalScifi", query = "SELECT u FROM Usuarios u WHERE u.calScifi = :calScifi"),
    @NamedQuery(name = "Usuarios.findByCalRoma", query = "SELECT u FROM Usuarios u WHERE u.calRoma = :calRoma")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "peso")
    private String peso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cal_accion")
    private String calAccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cal_comedia")
    private String calComedia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cal_terror")
    private String calTerror;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cal_animada")
    private String calAnimada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cal_scifi")
    private String calScifi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cal_roma")
    private String calRoma;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String peso, String calAccion, String calComedia, String calTerror, String calAnimada, String calScifi, String calRoma) {
        this.id = id;
        this.peso = peso;
        this.calAccion = calAccion;
        this.calComedia = calComedia;
        this.calTerror = calTerror;
        this.calAnimada = calAnimada;
        this.calScifi = calScifi;
        this.calRoma = calRoma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getCalAccion() {
        return calAccion;
    }

    public void setCalAccion(String calAccion) {
        this.calAccion = calAccion;
    }

    public String getCalComedia() {
        return calComedia;
    }

    public void setCalComedia(String calComedia) {
        this.calComedia = calComedia;
    }

    public String getCalTerror() {
        return calTerror;
    }

    public void setCalTerror(String calTerror) {
        this.calTerror = calTerror;
    }

    public String getCalAnimada() {
        return calAnimada;
    }

    public void setCalAnimada(String calAnimada) {
        this.calAnimada = calAnimada;
    }

    public String getCalScifi() {
        return calScifi;
    }

    public void setCalScifi(String calScifi) {
        this.calScifi = calScifi;
    }

    public String getCalRoma() {
        return calRoma;
    }

    public void setCalRoma(String calRoma) {
        this.calRoma = calRoma;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Usuarios[ id=" + id + " ]";
    }
    
}
