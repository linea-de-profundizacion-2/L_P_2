/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler_beans;

import com.entities.AuditoriaAnderson;
import com.entities.ProductoVendedor;
import com.jsf.ProductoVendedorFacade;
import com.jsf.ProductoVendedorFacadeLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author kefab
 */
@Named("controlproducto")
@Stateless
public class producto_registro implements Serializable {
private ProductoVendedor current;
     @EJB 
    private ProductoVendedorFacadeLocal profacade;
     private int selectedItemIndex;

   
    public ProductoVendedor getSelected() {
        if (current == null) {
            current = new ProductoVendedor();
            selectedItemIndex = -1;
        }
        return current;
    }
     public void editar(ProductoVendedor pro){
        try {
            
            
            profacade.edit(pro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"PRODUCTO ACTUALIZADO",""));
            System.out.println("producto registrado");
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"ERROR",""));
            System.out.println(".............eror.............."+ e);
        } 
     }
     
     public void liminar(ProductoVendedor pro){
        try {
            
            String pr=pro.getProducto();
            profacade.remove(pro);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"producto "+pr+"eliminado",""));
            System.out.println("producto registrado");
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"ERROR",""));
            System.out.println(".............eror.............."+ e);
        } }
     
      public void registrar(){
        try {
            
            
            profacade.create(current);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"PRODUCTO REGISTRADO",""));
            System.out.println("producto registrado");
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"ERROR",""));
            System.out.println(".............eror.............."+ e);
        }
        
      }

public void limpiar(){
    this.profacade=new ProductoVendedorFacade();
}
}
