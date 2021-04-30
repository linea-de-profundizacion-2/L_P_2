/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionsBean;

import com.entities.AuditoriaAnderson;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Time;
import java.util.Date;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kefab
 */
@Stateless
public class AuditoriaAndersonFacade extends AbstractFacade<AuditoriaAnderson> implements AuditoriaAndersonFacadeLocal {

    @PersistenceContext(unitName = "proyecto_lp2_jsfPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuditoriaAndersonFacade() {
        super(AuditoriaAnderson.class);
    }
    
  public String isverificar(int id ) {
        try {
            
         Query query= em.createQuery("SELECT a FROM AuditoriaAnderson a WHERE a.id = :id");
        query.setParameter("id",id);
         AuditoriaAnderson us =(AuditoriaAnderson) query.getSingleResult();
       String hora=us.getHora();
       String fecha=us.getFecha();
       String fec=hora+":00";
       System.out.println("fecha que genera la tabla    " +fec );
        if (us!=null) {
            
            return fec;
            
        }else {
        return null;
        }
         } catch (Exception e) {
             return null;
        }
     }
  

}