package de.htw.ai.graphql_db.storage;

import de.htw.ai.graphql_db.pojo.Author;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryAuthor implements AuthorDAO {
    private Map<Integer,Author> allAuthors;

    public InMemoryAuthor(){
        allAuthors = new HashMap<>();
        allAuthors.put(1,new Author(1,"Stephen","King"));
        allAuthors.put(2,new Author(2,"Bram","Stoker"));
    }

    @Override
    public Author getAuthorById(int id) {
        return allAuthors.get(id);
    }
}
