package org.example;

import org.example.entities.cd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.persistence.jpa.PersistenceProvider;


public class Main {
    private static EntityManagerFactory emf;
    public static void main(String[] args) {

        try{
            emf = new PersistenceProvider().createEntityManagerFactory("default", null);
            EntityManager em=emf.createEntityManager();

            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Entity Manager created ("+emf+")");
            em.getTransaction().begin();

            cd cd = new cd();

            cd.setCdName("The Dark Side of the Moon");
            cd.setBandName("Pink Floyd");

            em.persist(cd);

            em.getTransaction().commit();

            List<cd> listOfCds = em.createQuery("SELECT c FROM cd c").getResultList();
            System.out.println("\n------------------\nList of CD\n------------------");
            for (cd CdEntity : listOfCds) {
                System.out.println(CdEntity.getCdName() + " " + CdEntity.getBandName());
            }

            // demonstrate editing of an entity
            em.getTransaction().begin();
            cd.setCdName("The Dark Side of the Moon (Edited)");
            em.getTransaction().commit();


            listOfCds = em.createQuery("SELECT c FROM cd c").getResultList();
            System.out.println("\n------------------\nList of CD\n------------------");
            for (cd CdEntity : listOfCds) {
                System.out.println(CdEntity.getCdName() + " " + CdEntity.getBandName());
            }

            // demonstrate deleting of an entity
            em.getTransaction().begin();
            em.remove(cd);
            em.getTransaction().commit();

            listOfCds = em.createQuery("SELECT c FROM cd c").getResultList();
            System.out.println("\n------------------\nList of CD\n------------------");
            for (cd CdEntity : listOfCds) {
                System.out.println(CdEntity.getCdName() + " " + CdEntity.getBandName());
            }

            // demonstrate adding a new entity
            em.getTransaction().begin();
            cd = new cd();
            cd.setCdName("The Dark Side of the Moon (New)");
            cd.setBandName("Pink Floyd");
            em.persist(cd);
            em.getTransaction().commit();

            listOfCds = em.createQuery("SELECT c FROM cd c").getResultList();
            System.out.println("\n------------------\nList of CD\n------------------");
            for (cd CdEntity : listOfCds) {
                System.out.println(CdEntity.getCdName() + " " + CdEntity.getBandName());
            }


        }catch(Exception e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(emf!=null)
                emf.close();
        }
    }

}

