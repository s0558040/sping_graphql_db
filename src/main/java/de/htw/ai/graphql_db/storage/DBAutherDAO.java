package de.htw.ai.graphql_db.storage;

import de.htw.ai.graphql_db.pojo.Author;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DBAutherDAO implements AuthorDAO {
    @Autowired
    private EntityManagerFactory emf;

    @Override
    public Author getAuthorById(int id) {
        EntityManager em = emf.createEntityManager();
        Author author = null;
        try {
            author = em.find(Author.class,id);
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return author;
    }
}
