/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.IllegalOrphanException;
import controlador.exceptions.NonexistentEntityException;
import controlador.exceptions.PreexistingEntityException;
import entities.ProductoVendedor;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.UsuarioVendedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author kefab
 */
public class ProductoVendedorJpaController implements Serializable {

    public ProductoVendedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProductoVendedor productoVendedor) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        UsuarioVendedor usuarioVendedor1OrphanCheck = productoVendedor.getUsuarioVendedor1();
        if (usuarioVendedor1OrphanCheck != null) {
            ProductoVendedor oldProductoVendedorOfUsuarioVendedor1 = usuarioVendedor1OrphanCheck.getProductoVendedor();
            if (oldProductoVendedorOfUsuarioVendedor1 != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The UsuarioVendedor " + usuarioVendedor1OrphanCheck + " already has an item of type ProductoVendedor whose usuarioVendedor1 column cannot be null. Please make another selection for the usuarioVendedor1 field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioVendedor usuarioVendedor = productoVendedor.getUsuarioVendedor();
            if (usuarioVendedor != null) {
                usuarioVendedor = em.getReference(usuarioVendedor.getClass(), usuarioVendedor.getIDvendedor());
                productoVendedor.setUsuarioVendedor(usuarioVendedor);
            }
            UsuarioVendedor usuarioVendedor1 = productoVendedor.getUsuarioVendedor1();
            if (usuarioVendedor1 != null) {
                usuarioVendedor1 = em.getReference(usuarioVendedor1.getClass(), usuarioVendedor1.getIDvendedor());
                productoVendedor.setUsuarioVendedor1(usuarioVendedor1);
            }
            em.persist(productoVendedor);
            if (usuarioVendedor != null) {
                ProductoVendedor oldProductoVendedorOfUsuarioVendedor = usuarioVendedor.getProductoVendedor();
                if (oldProductoVendedorOfUsuarioVendedor != null) {
                    oldProductoVendedorOfUsuarioVendedor.setUsuarioVendedor(null);
                    oldProductoVendedorOfUsuarioVendedor = em.merge(oldProductoVendedorOfUsuarioVendedor);
                }
                usuarioVendedor.setProductoVendedor(productoVendedor);
                usuarioVendedor = em.merge(usuarioVendedor);
            }
            if (usuarioVendedor1 != null) {
                usuarioVendedor1.setProductoVendedor(productoVendedor);
                usuarioVendedor1 = em.merge(usuarioVendedor1);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProductoVendedor(productoVendedor.getIDvendedor()) != null) {
                throw new PreexistingEntityException("ProductoVendedor " + productoVendedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProductoVendedor productoVendedor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProductoVendedor persistentProductoVendedor = em.find(ProductoVendedor.class, productoVendedor.getIDvendedor());
            UsuarioVendedor usuarioVendedorOld = persistentProductoVendedor.getUsuarioVendedor();
            UsuarioVendedor usuarioVendedorNew = productoVendedor.getUsuarioVendedor();
            UsuarioVendedor usuarioVendedor1Old = persistentProductoVendedor.getUsuarioVendedor1();
            UsuarioVendedor usuarioVendedor1New = productoVendedor.getUsuarioVendedor1();
            List<String> illegalOrphanMessages = null;
            if (usuarioVendedorOld != null && !usuarioVendedorOld.equals(usuarioVendedorNew)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain UsuarioVendedor " + usuarioVendedorOld + " since its productoVendedor field is not nullable.");
            }
            if (usuarioVendedor1Old != null && !usuarioVendedor1Old.equals(usuarioVendedor1New)) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("You must retain UsuarioVendedor " + usuarioVendedor1Old + " since its productoVendedor field is not nullable.");
            }
            if (usuarioVendedor1New != null && !usuarioVendedor1New.equals(usuarioVendedor1Old)) {
                ProductoVendedor oldProductoVendedorOfUsuarioVendedor1 = usuarioVendedor1New.getProductoVendedor();
                if (oldProductoVendedorOfUsuarioVendedor1 != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The UsuarioVendedor " + usuarioVendedor1New + " already has an item of type ProductoVendedor whose usuarioVendedor1 column cannot be null. Please make another selection for the usuarioVendedor1 field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (usuarioVendedorNew != null) {
                usuarioVendedorNew = em.getReference(usuarioVendedorNew.getClass(), usuarioVendedorNew.getIDvendedor());
                productoVendedor.setUsuarioVendedor(usuarioVendedorNew);
            }
            if (usuarioVendedor1New != null) {
                usuarioVendedor1New = em.getReference(usuarioVendedor1New.getClass(), usuarioVendedor1New.getIDvendedor());
                productoVendedor.setUsuarioVendedor1(usuarioVendedor1New);
            }
            productoVendedor = em.merge(productoVendedor);
            if (usuarioVendedorNew != null && !usuarioVendedorNew.equals(usuarioVendedorOld)) {
                ProductoVendedor oldProductoVendedorOfUsuarioVendedor = usuarioVendedorNew.getProductoVendedor();
                if (oldProductoVendedorOfUsuarioVendedor != null) {
                    oldProductoVendedorOfUsuarioVendedor.setUsuarioVendedor(null);
                    oldProductoVendedorOfUsuarioVendedor = em.merge(oldProductoVendedorOfUsuarioVendedor);
                }
                usuarioVendedorNew.setProductoVendedor(productoVendedor);
                usuarioVendedorNew = em.merge(usuarioVendedorNew);
            }
            if (usuarioVendedor1New != null && !usuarioVendedor1New.equals(usuarioVendedor1Old)) {
                usuarioVendedor1New.setProductoVendedor(productoVendedor);
                usuarioVendedor1New = em.merge(usuarioVendedor1New);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = productoVendedor.getIDvendedor();
                if (findProductoVendedor(id) == null) {
                    throw new NonexistentEntityException("The productoVendedor with id " + id + " no longer exists.");
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
            ProductoVendedor productoVendedor;
            try {
                productoVendedor = em.getReference(ProductoVendedor.class, id);
                productoVendedor.getIDvendedor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productoVendedor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            UsuarioVendedor usuarioVendedorOrphanCheck = productoVendedor.getUsuarioVendedor();
            if (usuarioVendedorOrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ProductoVendedor (" + productoVendedor + ") cannot be destroyed since the UsuarioVendedor " + usuarioVendedorOrphanCheck + " in its usuarioVendedor field has a non-nullable productoVendedor field.");
            }
            UsuarioVendedor usuarioVendedor1OrphanCheck = productoVendedor.getUsuarioVendedor1();
            if (usuarioVendedor1OrphanCheck != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This ProductoVendedor (" + productoVendedor + ") cannot be destroyed since the UsuarioVendedor " + usuarioVendedor1OrphanCheck + " in its usuarioVendedor1 field has a non-nullable productoVendedor field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(productoVendedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProductoVendedor> findProductoVendedorEntities() {
        return findProductoVendedorEntities(true, -1, -1);
    }

    public List<ProductoVendedor> findProductoVendedorEntities(int maxResults, int firstResult) {
        return findProductoVendedorEntities(false, maxResults, firstResult);
    }

    private List<ProductoVendedor> findProductoVendedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProductoVendedor.class));
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

    public ProductoVendedor findProductoVendedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProductoVendedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoVendedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProductoVendedor> rt = cq.from(ProductoVendedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
