/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionsBean;

import com.entities.Usuario;
import static com.entities.Usuario_.rol;
import encrypt.sha256;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kefab
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "proyecto_lp2_jsfPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
     public long isVerified(String usuario, String contrasena) {
        try {
            
       
        Query query= em.createQuery("SELECT u FROM Usuario u WHERE u.usuario =:usuario And u.contrasena=:contrasena");
        query.setParameter("usuario",usuario);
        query.setParameter("contrasena",contrasena);
         Usuario us =(Usuario) query.getSingleResult();
        
        if (us==null) {
            
            return 0;
            
        }else {
        return 1;
        }
         } catch (Exception e) {
             return 0;
        }
     }

    public String encrypt(String usuario) {
        
         try {
           sha256 en=new sha256();
           String re=en.sha256(usuario);
           return re;
         } catch (Exception e) {
             return "0";
        }

    }

    

    @Override
    public int getUserId(String usuario) {
    try {
             String agri="agricultor";
       
        Query query= em.createQuery("SELECT u FROM Usuario u WHERE u.usuario=:usuario");
        query.setParameter("usuario",usuario);
         Usuario us =(Usuario) query.getSingleResult();
         String usrol=us.getRol();
        int val=usrol.length();
         System.out.println("usuario===" +usrol+"loong =="+ val);
        if (us==null) {
            
            return 0;
            
        }else {
            if (val==10) {
                return 1;
            }else{
                return 2;
            }
            }

         } catch (Exception e) {
             return 0;
        }
    }   
    }

    
    
       

