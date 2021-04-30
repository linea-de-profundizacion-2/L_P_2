/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionsBean;

import com.entities.Comprador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kefab
 */
@Stateless
public class CompradorFacade extends AbstractFacade<Comprador> implements CompradorFacadeLocal {

    @PersistenceContext(unitName = "proyecto_lp2_jsfPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompradorFacade() {
        super(Comprador.class);
    }
    
}
