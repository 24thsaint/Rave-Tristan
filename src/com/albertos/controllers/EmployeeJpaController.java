package com.albertos.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.albertos.objects.Employee;
import com.albertos.controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author hero
 */
public class EmployeeJpaController implements Serializable {

    public EmployeeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Employee validate(String username, String password) throws NoResultException{
        EntityManager em = null;
        em = getEntityManager();
        Query query = em.createQuery("SELECT a FROM "
                + "EmployeeRegistration a "
                + "WHERE username LIKE :user AND password LIKE :pass");
        query.setParameter("user", username);
        query.setParameter("pass", password);

        return (Employee) query.getSingleResult();
    }

    public void create(Employee employeeRegistration) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(employeeRegistration);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Employee employeeRegistration) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            employeeRegistration = em.merge(employeeRegistration);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = employeeRegistration.getId();
                if (findEmployeeRegistration(id) == null) {
                    throw new NonexistentEntityException("The employeeRegistration with id " + id + " no longer exists.");
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
            Employee employeeRegistration;
            try {
                employeeRegistration = em.getReference(Employee.class, id);
                employeeRegistration.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The employeeRegistration with id " + id + " no longer exists.", enfe);
            }
            em.remove(employeeRegistration);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Employee> findEmployeeRegistrationEntities() {
        return findEmployeeRegistrationEntities(true, -1, -1);
    }

    public List<Employee> findEmployeeRegistrationEntities(int maxResults, int firstResult) {
        return findEmployeeRegistrationEntities(false, maxResults, firstResult);
    }

    private List<Employee> findEmployeeRegistrationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Employee.class));
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

    public Employee findEmployeeRegistration(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Employee.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmployeeRegistrationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Employee> rt = cq.from(Employee.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
