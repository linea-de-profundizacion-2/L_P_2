/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler_beans;

import com.entities.Usuario;

import com.sessionsBean.UsuarioFacadeLocal;
import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author kefab
 */
@Named("logeo_controller")
@Stateless
public class controller_bean_loging {
     private Usuario current;
     @EJB 
    private UsuarioFacadeLocal usufacade;
     private int selectedItemIndex;
    
     public void logeo() throws IOException{
    String usuario;
    String contrasena;
    String rol;
    
    usuario= current.getUsuario();
    contrasena=current.getContrasena();
    rol=current.getRol();
    
        if (usufacade.isVerified(usuario, contrasena)==1) {
           
           
           if(usufacade.getUserId(usuario)==1) {
               
               FacesContext.getCurrentInstance().getExternalContext().redirect("/proyecto_lp2_jsf/faces/agricultor.xhtml");
                System.out.println("logeado1");
                
           } else {
               
                   FacesContext.getCurrentInstance().getExternalContext().redirect("/proyecto_lp2_jsf/faces/comprador.xhtml");
                    System.out.println("logeado2");
               }
        
        }else{
            FacesMessage facesMessage = new FacesMessage("Error al inciar, por favor verifique usuario y/o contraseña");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            System.out.println("no logeado");
        }
    
    }
     
      public Usuario getSelected() {
        if (current == null) {
            current = new Usuario();
            selectedItemIndex = -1;
            
        }
        return current;
    }
      
      
      
        
   
      
       public void registrar(){
        try {
            this.current.getUsuario();
            
            usufacade.create(current);
           
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario registrado correctamente",""));
            
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error",""));
            
        }
    }
      
      
      }
    
     
     

