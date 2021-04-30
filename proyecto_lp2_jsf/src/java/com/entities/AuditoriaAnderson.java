/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

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
 * @author kefab
 */
@Entity
@Table(name = "auditoria_anderson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditoriaAnderson.findAll", query = "SELECT a FROM AuditoriaAnderson a")
    , @NamedQuery(name = "AuditoriaAnderson.findById", query = "SELECT a FROM AuditoriaAnderson a WHERE a.id = :id")
    , @NamedQuery(name = "AuditoriaAnderson.findByUsuario", query = "SELECT a FROM AuditoriaAnderson a WHERE a.usuario = :usuario")
    , @NamedQuery(name = "AuditoriaAnderson.findByFecha", query = "SELECT a FROM AuditoriaAnderson a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "AuditoriaAnderson.findByAccionRealizada", query = "SELECT a FROM AuditoriaAnderson a WHERE a.accionRealizada = :accionRealizada")
    , @NamedQuery(name = "AuditoriaAnderson.findByHora", query = "SELECT a FROM AuditoriaAnderson a WHERE a.hora = :hora")})
public class AuditoriaAnderson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "accion_realizada")
    private String accionRealizada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "hora")
    private String hora;

    public AuditoriaAnderson() {
    }

    public AuditoriaAnderson(Integer id) {
        this.id = id;
    }

    public AuditoriaAnderson(Integer id, String usuario, String fecha, String accionRealizada, String hora) {
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
        this.accionRealizada = accionRealizada;
        this.hora = hora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAccionRealizada() {
        return accionRealizada;
    }

    public void setAccionRealizada(String accionRealizada) {
        this.accionRealizada = accionRealizada;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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
        if (!(object instanceof AuditoriaAnderson)) {
            return false;
        }
        AuditoriaAnderson other = (AuditoriaAnderson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.AuditoriaAnderson[ id=" + id + " ]";
    }
    
}
