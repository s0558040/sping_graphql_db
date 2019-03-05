package de.htw.ai.graphql_db.storage;

import de.htw.ai.graphql_db.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Component
public class DBBookDAO implements BookDAO {
    @Autowired
    private EntityManagerFactory emf;

    @Override
    public Book getBookById(int id) {
        EntityManager em = emf.createEntityManager();
        Book book = null;
        try {
            book = em.find(Book.class, id);
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return book;
    }

    @Override
    public Book getBookByTitle(String title) {
        EntityManager em = emf.createEntityManager();
        Book book = null;
        try {
            book = em.createQuery("select b from Book b where title=:book_title",Book.class)
                    .setParameter("book_title",title).getSingleResult();
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return book;
    }
}
