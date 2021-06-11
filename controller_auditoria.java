/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler_beans;

import com.entities.AuditoriaAnderson;
import com.jsf.util.PaginationHelper;
import com.sessionsBean.AuditoriaAndersonFacade;
import com.sessionsBean.AuditoriaAndersonFacadeLocal;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author kefab
 */
@Named("auditoriacontroller")
@Stateless
public class controller_auditoria implements Serializable {
private AuditoriaAnderson current;
     @EJB 
    private AuditoriaAndersonFacadeLocal auditoriafacade;
     private int selectedItemIndex;
      private PaginationHelper pagination;
  

    
   
    
     

    
public AuditoriaAnderson getSelected() {
        if (current == null) {
            current = new AuditoriaAnderson();
            selectedItemIndex = -1;
        }
        return current;
}

public Date horas (){
    
    
    
    Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		//Desplegamos la fecha
		Date tempDate = cal.getTime();
		System.out.println("Fecha actual: " + tempDate);
		Date fecha = new Date();
DateFormat hoy = new SimpleDateFormat("HHmmss");
                Date date = new Date();
                String hoyS =hoy.format(date).toString();
                int numEntero = Integer.parseInt(hoyS);
      
      
      
    
       
        System.out.println("fecha del dia de EN ENTERO  "+numEntero);
        
        
                
        
        DateFormat sss = new SimpleDateFormat("ddHHmmss");
                Date sd = new Date();
                
               cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) +15);
		sd = cal.getTime();
		System.out.println("Hora modificada: " + tempDate);
                
                String dddd =sss.format(sd).toString();
                
    int nu = Integer.parseInt(dddd);
       
        System.out.println("fecha del dia de EN ENTERO  "+nu);
               if (nu>=numEntero) {
                   System.out.println("la fecha anterior es mayor ");
        } else {
                   System.out.println("la fecha anterior no es mayor ");
        }
    
    return tempDate;
    

}
        public void registrar(){
        try {
            System.out.println("1111111111111111111111111111111111111111111111111111111");
            auditoriafacade.create(current);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"DATOS REGISTRADOS",""));
            System.out.println("datos registrados");
            
        } catch (Exception e) {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"ERROR",""));
            System.out.println(".............eror.............."+ e);
        }
    }
        
        
        public void validacion_fecha(){
           
        AuditoriaAnderson ss=new AuditoriaAnderson();
        
          

        }

 public void eliminacion_de_datos(AuditoriaAnderson pro) {
  
   
     try {
         
         int id=pro.getId();
                System.out.println("el valor en int es ::::::::::::::::::::::::::::::::: "+ id);
         
         String d=auditoriafacade.isverificar(id);
         String fe=d;
         Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		       System.out.println("sasasa"+fe);
		//Desplegamos la fecha
		Date tempDate = cal.getTime();
		System.out.println("Fecha actual: " + tempDate);
		Date fecha = new Date();
DateFormat hoy = new SimpleDateFormat("HHmmss");
                Date date = new Date();
                String hoyS =hoy.format(date).toString();
                int fecha_hoy = Integer.parseInt(hoyS);
      //FECHA ACTUAL EN ENTERO
                       String dni = fe.replaceAll("\\D+","");
                       System.out.println("como entero a date es " +dni);
          
            int value = Integer.parseInt(dni);
            int fecha_mas_q=value+1300;
            
            int fse=value+1500;
                
                   int hours=fse%1000000/10000;
                   int min=((fse)/100)%100;
                   int seg=fse%100;
                   int minuto=0;
                   int mn=min-60;
                   String valmin="";
                  if (hours>24){
                   hours=hours-24;
                   }
                  if (min>=60) {
                      
                      hours=hours+1;
                      
                      System.out.println("valor del minuto  ---------" + mn);
                 minuto=min-59;
                      System.out.println("valor del minuto  ---------" + minuto);
             } else {
                      minuto=min;
             }
                   System.out.println("fecha del dia de EN ENTERO mas 15 min  "+hours+":"+minuto+":"+seg);
            
            
            if (fecha_mas_q+200<=fecha_hoy) {
                
                 this.auditoriafacade.remove(pro);
         System.out.println("datos eliminados");
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Datos eliminados",""));
            } if(fecha_mas_q+200>fecha_hoy) {
                
               
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"podra eliminar los datos pasados 15 min despues del registro actual ",""));
            }
            
     } catch (Exception e) {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error al eliminar datos",""));
          System.out.println("datos no eliminados");
     }
   
        }
    
    
}
