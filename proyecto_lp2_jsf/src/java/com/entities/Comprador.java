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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kefab
 */
@Entity
@Table(name = "comprador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprador.findAll", query = "SELECT c FROM Comprador c")
    , @NamedQuery(name = "Comprador.findByIDcomprador", query = "SELECT c FROM Comprador c WHERE c.iDcomprador = :iDcomprador")
    , @NamedQuery(name = "Comprador.findByDireccion", query = "SELECT c FROM Comprador c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Comprador.findByCiudad", query = "SELECT c FROM Comprador c WHERE c.ciudad = :ciudad")})
public class Comprador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_comprador")
    private Integer iDcomprador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ciudad")
    private String ciudad;
    @JoinColumn(name = "ID_comprador", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Comprador() {
    }

    public Comprador(Integer iDcomprador) {
        this.iDcomprador = iDcomprador;
    }

    public Comprador(Integer iDcomprador, String direccion, String ciudad) {
        this.iDcomprador = iDcomprador;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public Integer getIDcomprador() {
        return iDcomprador;
    }

    public void setIDcomprador(Integer iDcomprador) {
        this.iDcomprador = iDcomprador;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDcomprador != null ? iDcomprador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprador)) {
            return false;
        }
        Comprador other = (Comprador) object;
        if ((this.iDcomprador == null && other.iDcomprador != null) || (this.iDcomprador != null && !this.iDcomprador.equals(other.iDcomprador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Comprador[ iDcomprador=" + iDcomprador + " ]";
    }
    
}
