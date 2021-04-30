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
import javax.persistence.ManyToOne;
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
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v")
    , @NamedQuery(name = "Vendedor.findByIDvendedor", query = "SELECT v FROM Vendedor v WHERE v.iDvendedor = :iDvendedor")
    , @NamedQuery(name = "Vendedor.findByDireccion", query = "SELECT v FROM Vendedor v WHERE v.direccion = :direccion")
    , @NamedQuery(name = "Vendedor.findByCiudad", query = "SELECT v FROM Vendedor v WHERE v.ciudad = :ciudad")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_vendedor")
    private Integer iDvendedor;
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
    @JoinColumn(name = "ID_vendedor", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "producto", referencedColumnName = "ID_Producto")
    @ManyToOne(optional = false)
    private Producto producto;

    public Vendedor() {
    }

    public Vendedor(Integer iDvendedor) {
        this.iDvendedor = iDvendedor;
    }

    public Vendedor(Integer iDvendedor, String direccion, String ciudad) {
        this.iDvendedor = iDvendedor;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public Integer getIDvendedor() {
        return iDvendedor;
    }

    public void setIDvendedor(Integer iDvendedor) {
        this.iDvendedor = iDvendedor;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDvendedor != null ? iDvendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.iDvendedor == null && other.iDvendedor != null) || (this.iDvendedor != null && !this.iDvendedor.equals(other.iDvendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Vendedor[ iDvendedor=" + iDvendedor + " ]";
    }
    
}
