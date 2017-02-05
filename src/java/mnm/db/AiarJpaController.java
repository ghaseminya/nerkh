/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mnm.db;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import mnm.db.exceptions.NonexistentEntityException;

/**
 *
 * @author mnm
 */
public class AiarJpaController implements Serializable {

    public AiarJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aiar aiar) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(aiar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aiar aiar) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            aiar = em.merge(aiar);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = aiar.getIdaiar();
                if (findAiar(id) == null) {
                    throw new NonexistentEntityException("The aiar with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aiar aiar;
            try {
                aiar = em.getReference(Aiar.class, id);
                aiar.getIdaiar();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aiar with id " + id + " no longer exists.", enfe);
            }
            em.remove(aiar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aiar> findAiarEntities() {
        return findAiarEntities(true, -1, -1);
    }

    public List<Aiar> findAiarEntities(int maxResults, int firstResult) {
        return findAiarEntities(false, maxResults, firstResult);
    }

    private List<Aiar> findAiarEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aiar.class));
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

    public Aiar findAiar(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aiar.class, id);
        } finally {
            em.close();
        }
    }

    public int getAiarCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aiar> rt = cq.from(Aiar.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
