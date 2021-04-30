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
@Table(name = "producto_vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoVendedor.findAll", query = "SELECT p FROM ProductoVendedor p")
    , @NamedQuery(name = "ProductoVendedor.findByIDproducto", query = "SELECT p FROM ProductoVendedor p WHERE p.iDproducto = :iDproducto")
    , @NamedQuery(name = "ProductoVendedor.findByProducto", query = "SELECT p FROM ProductoVendedor p WHERE p.producto = :producto")
    , @NamedQuery(name = "ProductoVendedor.findByPrecio", query = "SELECT p FROM ProductoVendedor p WHERE p.precio = :precio")
    , @NamedQuery(name = "ProductoVendedor.findByDescripcion", query = "SELECT p FROM ProductoVendedor p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "ProductoVendedor.findByCantidadProducto", query = "SELECT p FROM ProductoVendedor p WHERE p.cantidadProducto = :cantidadProducto")
    , @NamedQuery(name = "ProductoVendedor.findByUnidad", query = "SELECT p FROM ProductoVendedor p WHERE p.unidad = :unidad")
    , @NamedQuery(name = "ProductoVendedor.findByFechaPublicacion", query = "SELECT p FROM ProductoVendedor p WHERE p.fechaPublicacion = :fechaPublicacion")
    , @NamedQuery(name = "ProductoVendedor.findByUrlImagen", query = "SELECT p FROM ProductoVendedor p WHERE p.urlImagen = :urlImagen")})
public class ProductoVendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_producto")
    private Integer iDproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "producto")
    private String producto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "precio")
    private String precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cantidad_producto")
    private String cantidadProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "unidad")
    private String unidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fecha_publicacion")
    private String fechaPublicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "url_imagen")
    private String urlImagen;

    public ProductoVendedor() {
    }

    public ProductoVendedor(Integer iDproducto) {
        this.iDproducto = iDproducto;
    }

    public ProductoVendedor(Integer iDproducto, String producto, String precio, String descripcion, String cantidadProducto, String unidad, String fechaPublicacion, String urlImagen) {
        this.iDproducto = iDproducto;
        this.producto = producto;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidadProducto = cantidadProducto;
        this.unidad = unidad;
        this.fechaPublicacion = fechaPublicacion;
        this.urlImagen = urlImagen;
    }

    public Integer getIDproducto() {
        return iDproducto;
    }

    public void setIDproducto(Integer iDproducto) {
        this.iDproducto = iDproducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDproducto != null ? iDproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoVendedor)) {
            return false;
        }
        ProductoVendedor other = (ProductoVendedor) object;
        if ((this.iDproducto == null && other.iDproducto != null) || (this.iDproducto != null && !this.iDproducto.equals(other.iDproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.ProductoVendedor[ iDproducto=" + iDproducto + " ]";
    }
    
}
