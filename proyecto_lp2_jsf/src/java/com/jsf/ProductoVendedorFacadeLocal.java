/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

import com.entities.ProductoVendedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kefab
 */
@Local
public interface ProductoVendedorFacadeLocal {

    void create(ProductoVendedor productoVendedor);

    void edit(ProductoVendedor productoVendedor);

    void remove(ProductoVendedor productoVendedor);

    ProductoVendedor find(Object id);

    List<ProductoVendedor> findAll();

    List<ProductoVendedor> findRange(int[] range);

    int count();
    
}
