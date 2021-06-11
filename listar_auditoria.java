/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler_beans;

import com.entities.AuditoriaAnderson;
import com.entities.ProductoVendedor;
import com.sessionsBean.AuditoriaAndersonFacadeLocal;
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
@Named("audit")
@Stateless
public class listar_auditoria implements Serializable {
@EJB
 private AuditoriaAndersonFacadeLocal audfacade;
 private List<AuditoriaAnderson> listau;
 private AuditoriaAnderson productovendedor;

    public AuditoriaAndersonFacadeLocal getAudfacade() {
        return audfacade;
    }

    public void setAudfacade(AuditoriaAndersonFacadeLocal audfacade) {
        this.audfacade = audfacade;
    }

    public List<AuditoriaAnderson> getListau() {
        this.listau=this.audfacade.findAll();
        return listau;
    }

    public void setListau(List<AuditoriaAnderson> listau) {
        this.listau = listau;
    }

    public AuditoriaAnderson getProductovendedor() {
        return productovendedor;
    }

    public void setProductovendedor(AuditoriaAnderson productovendedor) {
        this.productovendedor = productovendedor;
    }
 @PostConstruct
 public void init(){
 this.productovendedor = new AuditoriaAnderson();
}
}
