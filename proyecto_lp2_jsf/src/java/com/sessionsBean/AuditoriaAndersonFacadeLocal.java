/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sessionsBean;

import com.entities.AuditoriaAnderson;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kefab
 */
@Local
public interface AuditoriaAndersonFacadeLocal {

    void create(AuditoriaAnderson auditoriaAnderson);

    void edit(AuditoriaAnderson auditoriaAnderson);

    void remove(AuditoriaAnderson auditoriaAnderson);

    AuditoriaAnderson find(Object id);

    List<AuditoriaAnderson> findAll();

    List<AuditoriaAnderson> findRange(int[] range);

    int count();
     
     public String isverificar(int id );
    
}
