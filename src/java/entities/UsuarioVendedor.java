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
@Table(name = "usuario_vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioVendedor.findAll", query = "SELECT u FROM UsuarioVendedor u")
    , @NamedQuery(name = "UsuarioVendedor.findByIDvendedor", query = "SELECT u FROM UsuarioVendedor u WHERE u.iDvendedor = :iDvendedor")
    , @NamedQuery(name = "UsuarioVendedor.findByUsuario", query = "SELECT u FROM UsuarioVendedor u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "UsuarioVendedor.findByContrasena", query = "SELECT u FROM UsuarioVendedor u WHERE u.contrasena = :contrasena")})
public class UsuarioVendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_vendedor")
    private Integer iDvendedor;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private int contrasena;
    @JoinColumn(name = "ID_vendedor", referencedColumnName = "ID_vendedor", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private ProductoVendedor productoVendedor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuarioVendedor1")
    private ProductoVendedor productoVendedor1;

    public UsuarioVendedor() {
    }

    public UsuarioVendedor(Integer iDvendedor) {
        this.iDvendedor = iDvendedor;
    }

    public UsuarioVendedor(Integer iDvendedor, String usuario, int contrasena) {
        this.iDvendedor = iDvendedor;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Integer getIDvendedor() {
        return iDvendedor;
    }

    public void setIDvendedor(Integer iDvendedor) {
        this.iDvendedor = iDvendedor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getContrasena() {
        return contrasena;
    }

    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }

    public ProductoVendedor getProductoVendedor() {
        return productoVendedor;
    }

    public void setProductoVendedor(ProductoVendedor productoVendedor) {
        this.productoVendedor = productoVendedor;
    }

    public ProductoVendedor getProductoVendedor1() {
        return productoVendedor1;
    }

    public void setProductoVendedor1(ProductoVendedor productoVendedor1) {
        this.productoVendedor1 = productoVendedor1;
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
        if (!(object instanceof UsuarioVendedor)) {
            return false;
        }
        UsuarioVendedor other = (UsuarioVendedor) object;
        if ((this.iDvendedor == null && other.iDvendedor != null) || (this.iDvendedor != null && !this.iDvendedor.equals(other.iDvendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UsuarioVendedor[ iDvendedor=" + iDvendedor + " ]";
    }
    
}
