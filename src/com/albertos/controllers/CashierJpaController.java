/*
 *  ==++++++++++++++++++++++++++++++++++++++++++++++++++++==
 *  |      CENTRAL PHILIPPINE UNIVERSITY                   |
 *  |      Bachelor of Science in Software Engineering     |
 *  |      Jaro, Iloilo City, Philippines                  |
 *  |                                                      |
 *  |          This program is written by Rave, ©2015.     |
 *  |          You are free to use and distribute this.    |
 *  |          Reach me at: admin@blackout.biz.tm          |
 *  |                                                      |
 *  |               ~~~"CODE the FUTURE"~~~                |
 *  ==++++++++++++++++++++++++++++++++++++++++++++++++++++==
 */
package com.albertos.controllers;

import com.albertos.cashiermanager.Cashier;
import com.albertos.controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Rave Noren Gidor-Sambo Villavicencio-Arevalo
 */
public class CashierJpaController implements Serializable {

    public CashierJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cashier cashier) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cashier);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cashier cashier) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cashier = em.merge(cashier);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cashier.getId();
                if (findCashier(id) == null) {
                    throw new NonexistentEntityException("The cashier with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cashier cashier;
            try {
                cashier = em.getReference(Cashier.class, id);
                cashier.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cashier with id " + id + " no longer exists.", enfe);
            }
            em.remove(cashier);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cashier> findCashierEntities() {
        return findCashierEntities(true, -1, -1);
    }

    public List<Cashier> findCashierEntities(int maxResults, int firstResult) {
        return findCashierEntities(false, maxResults, firstResult);
    }

    private List<Cashier> findCashierEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cashier.class));
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

    public Cashier findCashier(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cashier.class, id);
        } finally {
            em.close();
        }
    }

    public int getCashierCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cashier> rt = cq.from(Cashier.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
