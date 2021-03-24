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
@Table(name = "comprador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprador.findAll", query = "SELECT c FROM Comprador c")
    , @NamedQuery(name = "Comprador.findByIDcomprador", query = "SELECT c FROM Comprador c WHERE c.iDcomprador = :iDcomprador")
    , @NamedQuery(name = "Comprador.findByUsuario", query = "SELECT c FROM Comprador c WHERE c.usuario = :usuario")
    , @NamedQuery(name = "Comprador.findByContrasena", query = "SELECT c FROM Comprador c WHERE c.contrasena = :contrasena")})
public class Comprador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_comprador")
    private Integer iDcomprador;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @JoinColumn(name = "ID_comprador", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuari usuari;

    public Comprador() {
    }

    public Comprador(Integer iDcomprador) {
        this.iDcomprador = iDcomprador;
    }

    public Comprador(Integer iDcomprador, String usuario, String contrasena) {
        this.iDcomprador = iDcomprador;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Integer getIDcomprador() {
        return iDcomprador;
    }

    public void setIDcomprador(Integer iDcomprador) {
        this.iDcomprador = iDcomprador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
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
        return "entities.Comprador[ iDcomprador=" + iDcomprador + " ]";
    }
    
}
