package de.htw.ai.graphql_db.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import de.htw.ai.graphql_db.pojo.Author;
import de.htw.ai.graphql_db.pojo.Book;
import de.htw.ai.graphql_db.storage.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorResolver implements GraphQLResolver<Book> {
    @Autowired
    private AuthorDAO authorDAO;

    public Author getAuthor(Book book){
        return authorDAO.getAuthorById(book.getAuthor().getAuthor_id());
    }
}
