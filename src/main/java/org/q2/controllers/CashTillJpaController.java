/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.q2.controllers;

import org.q2.controllers.exceptions.NonexistentEntityException;
import org.q2.entities.CashTill;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;


public class CashTillJpaController implements Serializable {

    public CashTillJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CashTill cashTill) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cashTill);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CashTill cashTill) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cashTill = em.merge(cashTill);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cashTill.getId();
                if (findCashTill(id) == null) {
                    throw new NonexistentEntityException("The cashTill with id " + id + " no longer exists.");
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
            CashTill cashTill;
            try {
                cashTill = em.getReference(CashTill.class, id);
                cashTill.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cashTill with id " + id + " no longer exists.", enfe);
            }
            em.remove(cashTill);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CashTill> findCashTillEntities() {
        return findCashTillEntities(true, -1, -1);
    }

    public List<CashTill> findCashTillEntities(int maxResults, int firstResult) {
        return findCashTillEntities(false, maxResults, firstResult);
    }

    private List<CashTill> findCashTillEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from CashTill as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public CashTill findCashTill(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CashTill.class, id);
        } finally {
            em.close();
        }
    }

    public int getCashTillCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from CashTill as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
