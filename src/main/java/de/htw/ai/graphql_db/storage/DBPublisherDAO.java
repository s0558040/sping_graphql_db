package de.htw.ai.graphql_db.storage;

import de.htw.ai.graphql_db.pojo.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Component
public class DBPublisherDAO implements PublisherDAO {
    @Autowired
    private EntityManagerFactory emf;

    @Override
    public Publisher getPublisherById(int id) {
        EntityManager em = emf.createEntityManager();
        Publisher publisher = null;
        try {
            publisher = em.find(Publisher.class, id);
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return publisher;
    }

    @Override
    public Publisher getPublisherByName(String name) {
        EntityManager em = emf.createEntityManager();
        Publisher publisher = null;
        try {
            publisher = em.createQuery("select p from Publisher p where company_name=:company",Publisher.class)
                    .setParameter("company",name).getSingleResult();
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return publisher;
    }
}
