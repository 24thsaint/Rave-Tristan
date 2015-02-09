package com.albertos.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.albertos.objects.Ingredient;
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
 * @author hero
 */
public class IngredientJpaController implements Serializable {

    public IngredientJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ingredient ingredientInventory) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ingredientInventory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Ingredient seachByIngredientName(String name) {
        EntityManager em = null;
        Query query = null;
        try {
            em = getEntityManager();
            query = em.createQuery("SELECT i "
                    + "FROM IngredientInventory i WHERE i.ingredientName=:qq");
            query.setParameter("qq", name);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (Ingredient) query.getSingleResult();
    }

    public void edit(Ingredient ingredientInventory) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ingredientInventory = em.merge(ingredientInventory);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = ingredientInventory.getId();
                if (findIngredientInventory(id) == null) {
                    throw new NonexistentEntityException("The ingredientInventory with id " + id + " no longer exists.");
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
            Ingredient ingredientInventory;
            try {
                ingredientInventory = em.getReference(Ingredient.class, id);
                ingredientInventory.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ingredientInventory with id " + id + " no longer exists.", enfe);
            }
            em.remove(ingredientInventory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ingredient> findIngredientInventoryEntities() {
        return findIngredientInventoryEntities(true, -1, -1);
    }

    public List<Ingredient> findIngredientInventoryEntities(int maxResults, int firstResult) {
        return findIngredientInventoryEntities(false, maxResults, firstResult);
    }

    private List<Ingredient> findIngredientInventoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ingredient.class));
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

    public Ingredient findIngredientInventory(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ingredient.class, id);
        } finally {
            em.close();
        }
    }

    public int getIngredientInventoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ingredient> rt = cq.from(Ingredient.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
