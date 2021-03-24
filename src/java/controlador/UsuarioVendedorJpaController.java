/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.IllegalOrphanException;
import controlador.exceptions.NonexistentEntityException;
import controlador.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.ProductoVendedor;
import entities.UsuarioVendedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author kefab
 */
public class UsuarioVendedorJpaController implements Serializable {

    public UsuarioVendedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioVendedor usuarioVendedor) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        ProductoVendedor productoVendedorOrphanCheck = usuarioVendedor.getProductoVendedor();
        if (productoVendedorOrphanCheck != null) {
            UsuarioVendedor oldUsuarioVendedorOfProductoVendedor = productoVendedorOrphanCheck.getUsuarioVendedor();
            if (oldUsuarioVendedorOfProductoVendedor != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The ProductoVendedor " + productoVendedorOrphanCheck + " already has an item of type UsuarioVendedor whose productoVendedor column cannot be null. Please make another selection for the productoVendedor field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductoVendedor productoVendedor = usuarioVendedor.getProductoVendedor();
            if (productoVendedor != null) {
                productoVendedor = em.getReference(productoVendedor.getClass(), productoVendedor.getIDvendedor());
                usuarioVendedor.setProductoVendedor(productoVendedor);
            }
            ProductoVendedor productoVendedor1 = usuarioVendedor.getProductoVendedor1();
            if (productoVendedor1 != null) {
                productoVendedor1 = em.getReference(productoVendedor1.getClass(), productoVendedor1.getIDvendedor());
                usuarioVendedor.setProductoVendedor1(productoVendedor1);
            }
            em.persist(usuarioVendedor);
            if (productoVendedor != null) {
                productoVendedor.setUsuarioVendedor(usuarioVendedor);
                productoVendedor = em.merge(productoVendedor);
            }
            if (productoVendedor1 != null) {
                UsuarioVendedor oldUsuarioVendedor1OfProductoVendedor1 = productoVendedor1.getUsuarioVendedor1();
                if (oldUsuarioVendedor1OfProductoVendedor1 != null) {
                    oldUsuarioVendedor1OfProductoVendedor1.setProductoVendedor1(null);
                    oldUsuarioVendedor1OfProductoVendedor1 = em.merge(oldUsuarioVendedor1OfProductoVendedor1);
                }
                productoVendedor1.setUsuarioVendedor1(usuarioVendedor);
                productoVendedor1 = em.merge(productoVendedor1);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuarioVendedor(usuarioVendedor.getIDvendedor()) != null) {
                throw new PreexistingEntityException("UsuarioVendedor " + usuarioVendedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioVendedor usuarioVendedor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioVendedor persistentUsuarioVendedor = em.find(UsuarioVendedor.class, usuarioVendedor.getIDvendedor());
            ProductoVendedor productoVendedorOld = persistentUsuarioVendedor.getProductoVendedor();
            ProductoVendedor productoVendedorNew = usuarioVendedor.getProductoVendedor();
            ProductoVendedor productoVendedor1Old = persistentUsuarioVendedor.getProductoVendedor1();
            ProductoVendedor productoVendedor1New = usuarioVendedor.getProductoVendedor1();
            List<String> illegalOrphanMessages = null;
            if (productoVendedorNew != null && !productoVendedorNew.equals(productoVendedorOld)) {
                UsuarioVendedor oldUsuarioVendedorOfProductoVendedor = productoVendedorNew.getUsuarioVendedor();
                if (oldUsuarioVendedorOfProductoVendedor != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The ProductoVendedor " + productoVendedorNew + " already has an item of type UsuarioVendedor whose productoVendedor column cannot be null. Please make another selection for the productoVendedor field.");
                }
            }
            if (productoVendedor1Old != null && !productoVendedor1Old.equals(productoVendedor1New)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain ProductoVendedor " + productoVendedor1Old + " since its usuarioVendedor1 field is not nullable.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (productoVendedorNew != null) {
                productoVendedorNew = em.getReference(productoVendedorNew.getClass(), productoVendedorNew.getIDvendedor());
                usuarioVendedor.setProductoVendedor(productoVendedorNew);
            }
            if (productoVendedor1New != null) {
                productoVendedor1New = em.getReference(productoVendedor1New.getClass(), productoVendedor1New.getIDvendedor());
                usuarioVendedor.setProductoVendedor1(productoVendedor1New);
            }
            usuarioVendedor = em.merge(usuarioVendedor);
            if (productoVendedorOld != null && !productoVendedorOld.equals(productoVendedorNew)) {
                productoVendedorOld.setUsuarioVendedor(null);
                productoVendedorOld = em.merge(productoVendedorOld);
            }
            if (productoVendedorNew != null && !productoVendedorNew.equals(productoVendedorOld)) {
                productoVendedorNew.setUsuarioVendedor(usuarioVendedor);
                productoVendedorNew = em.merge(productoVendedorNew);
            }
            if (productoVendedor1New != null && !productoVendedor1New.equals(productoVendedor1Old)) {
                UsuarioVendedor oldUsuarioVendedor1OfProductoVendedor1 = productoVendedor1New.getUsuarioVendedor1();
                if (oldUsuarioVendedor1OfProductoVendedor1 != null) {
                    oldUsuarioVendedor1OfProductoVendedor1.setProductoVendedor1(null);
                    oldUsuarioVendedor1OfProductoVendedor1 = em.merge(oldUsuarioVendedor1OfProductoVendedor1);
                }
                productoVendedor1New.setUsuarioVendedor1(usuarioVendedor);
                productoVendedor1New = em.merge(productoVendedor1New);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuarioVendedor.getIDvendedor();
                if (findUsuarioVendedor(id) == null) {
                    throw new NonexistentEntityException("The usuarioVendedor with id " + id + " no longer exists.");
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
            UsuarioVendedor usuarioVendedor;
            try {
                usuarioVendedor = em.getReference(UsuarioVendedor.class, id);
                usuarioVendedor.getIDvendedor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioVendedor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            ProductoVendedor productoVendedor1OrphanCheck = usuarioVendedor.getProductoVendedor1();
            if (productoVendedor1OrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This UsuarioVendedor (" + usuarioVendedor + ") cannot be destroyed since the ProductoVendedor " + productoVendedor1OrphanCheck + " in its productoVendedor1 field has a non-nullable usuarioVendedor1 field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            ProductoVendedor productoVendedor = usuarioVendedor.getProductoVendedor();
            if (productoVendedor != null) {
                productoVendedor.setUsuarioVendedor(null);
                productoVendedor = em.merge(productoVendedor);
            }
            em.remove(usuarioVendedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioVendedor> findUsuarioVendedorEntities() {
        return findUsuarioVendedorEntities(true, -1, -1);
    }

    public List<UsuarioVendedor> findUsuarioVendedorEntities(int maxResults, int firstResult) {
        return findUsuarioVendedorEntities(false, maxResults, firstResult);
    }

    private List<UsuarioVendedor> findUsuarioVendedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioVendedor.class));
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

    public UsuarioVendedor findUsuarioVendedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioVendedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioVendedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioVendedor> rt = cq.from(UsuarioVendedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
