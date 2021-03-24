/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    , @NamedQuery(name = "ProductoVendedor.findByIDvendedor", query = "SELECT p FROM ProductoVendedor p WHERE p.iDvendedor = :iDvendedor")
    , @NamedQuery(name = "ProductoVendedor.findByIDproducto", query = "SELECT p FROM ProductoVendedor p WHERE p.iDproducto = :iDproducto")
    , @NamedQuery(name = "ProductoVendedor.findByNombreProducto", query = "SELECT p FROM ProductoVendedor p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "ProductoVendedor.findByDescripcion", query = "SELECT p FROM ProductoVendedor p WHERE p.descripcion = :descripcion")})
public class ProductoVendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_vendedor")
    private Integer iDvendedor;
    @Basic(optional = false)
    @Column(name = "ID_producto")
    private int iDproducto;
    @Basic(optional = false)
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productoVendedor")
    private UsuarioVendedor usuarioVendedor;
    @JoinColumn(name = "ID_vendedor", referencedColumnName = "ID_vendedor", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UsuarioVendedor usuarioVendedor1;

    public ProductoVendedor() {
    }

    public ProductoVendedor(Integer iDvendedor) {
        this.iDvendedor = iDvendedor;
    }

    public ProductoVendedor(Integer iDvendedor, int iDproducto, String nombreProducto, String descripcion) {
        this.iDvendedor = iDvendedor;
        this.iDproducto = iDproducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
    }

    public Integer getIDvendedor() {
        return iDvendedor;
    }

    public void setIDvendedor(Integer iDvendedor) {
        this.iDvendedor = iDvendedor;
    }

    public int getIDproducto() {
        return iDproducto;
    }

    public void setIDproducto(int iDproducto) {
        this.iDproducto = iDproducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UsuarioVendedor getUsuarioVendedor() {
        return usuarioVendedor;
    }

    public void setUsuarioVendedor(UsuarioVendedor usuarioVendedor) {
        this.usuarioVendedor = usuarioVendedor;
    }

    public UsuarioVendedor getUsuarioVendedor1() {
        return usuarioVendedor1;
    }

    public void setUsuarioVendedor1(UsuarioVendedor usuarioVendedor1) {
        this.usuarioVendedor1 = usuarioVendedor1;
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
        if (!(object instanceof ProductoVendedor)) {
            return false;
        }
        ProductoVendedor other = (ProductoVendedor) object;
        if ((this.iDvendedor == null && other.iDvendedor != null) || (this.iDvendedor != null && !this.iDvendedor.equals(other.iDvendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProductoVendedor[ iDvendedor=" + iDvendedor + " ]";
    }
    
}
