package de.htw.ai.graphql_db.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import de.htw.ai.graphql_db.pojo.Author;
import de.htw.ai.graphql_db.pojo.Book;
import de.htw.ai.graphql_db.pojo.Publisher;
import de.htw.ai.graphql_db.storage.AuthorDAO;
import de.htw.ai.graphql_db.storage.BookDAO;
import de.htw.ai.graphql_db.storage.InMemoryAuthor;
import de.htw.ai.graphql_db.storage.PublisherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    private AuthorDAO authorDAO;
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private PublisherDAO publisherDAO;

    public Author getAuthor(int id){
        return authorDAO.getAuthorById(id);
    }

    public Book getBook(int isbn){
        return bookDAO.getBookById(isbn);
    }

    public Publisher getPublisher(int id){
        return publisherDAO.getPublisherById(id);
    }
}
