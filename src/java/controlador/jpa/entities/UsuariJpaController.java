/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.jpa.entities;

import controlador.exceptions.IllegalOrphanException;
import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Comprador;
import entities.Usuari;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kefab
 */
public class UsuariJpaController implements Serializable {


public UsuariJpaController() {
  
        this.emf =   Persistence.createEntityManagerFactory("jpa_2PU");
    }


    public UsuariJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

   
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuari usuari) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comprador comprador = usuari.getComprador();
            if (comprador != null) {
                comprador = em.getReference(comprador.getClass(), comprador.getIDcomprador());
                usuari.setComprador(comprador);
            }
            em.persist(usuari);
            if (comprador != null) {
                Usuari oldUsuariOfComprador = comprador.getUsuari();
                if (oldUsuariOfComprador != null) {
                    oldUsuariOfComprador.setComprador(null);
                    oldUsuariOfComprador = em.merge(oldUsuariOfComprador);
                }
                comprador.setUsuari(usuari);
                comprador = em.merge(comprador);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuari usuari) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuari persistentUsuari = em.find(Usuari.class, usuari.getId());
            Comprador compradorOld = persistentUsuari.getComprador();
            Comprador compradorNew = usuari.getComprador();
            List<String> illegalOrphanMessages = null;
            if (compradorOld != null && !compradorOld.equals(compradorNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain Comprador " + compradorOld + " since its usuari field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (compradorNew != null) {
                compradorNew = em.getReference(compradorNew.getClass(), compradorNew.getIDcomprador());
                usuari.setComprador(compradorNew);
            }
            usuari = em.merge(usuari);
            if (compradorNew != null && !compradorNew.equals(compradorOld)) {
                Usuari oldUsuariOfComprador = compradorNew.getUsuari();
                if (oldUsuariOfComprador != null) {
                    oldUsuariOfComprador.setComprador(null);
                    oldUsuariOfComprador = em.merge(oldUsuariOfComprador);
                }
                compradorNew.setUsuari(usuari);
                compradorNew = em.merge(compradorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuari.getId();
                if (findUsuari(id) == null) {
                    throw new NonexistentEntityException("The usuari with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuari usuari;
            try {
                usuari = em.getReference(Usuari.class, id);
                usuari.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuari with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Comprador compradorOrphanCheck = usuari.getComprador();
            if (compradorOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuari (" + usuari + ") cannot be destroyed since the Comprador " + compradorOrphanCheck + " in its comprador field has a non-nullable usuari field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(usuari);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuari> findUsuariEntities() {
        return findUsuariEntities(true, -1, -1);
    }

    public List<Usuari> findUsuariEntities(int maxResults, int firstResult) {
        return findUsuariEntities(false, maxResults, firstResult);
    }

    private List<Usuari> findUsuariEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuari.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Usuari findUsuari(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuari.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuariCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuari> rt = cq.from(Usuari.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
