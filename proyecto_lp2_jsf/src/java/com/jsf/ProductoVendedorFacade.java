/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

import com.entities.ProductoVendedor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kefab
 */
@Stateless
public class ProductoVendedorFacade extends AbstractFacade<ProductoVendedor> implements ProductoVendedorFacadeLocal {

    @PersistenceContext(unitName = "proyecto_lp2_jsfPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoVendedorFacade() {
        super(ProductoVendedor.class);
    }
    
}
