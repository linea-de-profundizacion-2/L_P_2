/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler_beans;

import com.entities.ProductoVendedor;
import com.entities.Usuario;
import com.jsf.ProductoVendedorFacadeLocal;
import com.sessionsBean.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author kefab
 */
@Named("listarproductos")
@Stateless
public class listar_productos implements Serializable {


  @EJB
 private ProductoVendedorFacadeLocal profacade;
 private List<ProductoVendedor> listpro;
 private ProductoVendedor productovendedor;

    public ProductoVendedorFacadeLocal getProfacade() {
        return profacade;
    }

    public void setProfacade(ProductoVendedorFacadeLocal profacade) {
        this.profacade = profacade;
    }

    public List<ProductoVendedor> getListpro() {
        this.listpro=this.profacade.findAll();
        return listpro;
    }

    public void setListpro(List<ProductoVendedor> listpro) {
        this.listpro = listpro;
    }

    public ProductoVendedor getProductovendedor() {
        return productovendedor;
    }

    public void setProductovendedor(ProductoVendedor productovendedor) {
        this.productovendedor = productovendedor;
    }
 
 @PostConstruct
 public void init(){
 this.productovendedor = new ProductoVendedor();
}


 }
 