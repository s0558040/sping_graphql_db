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
        initHashMap();
    }

    private void initHashMap(){
        Author author1 = new Author();
        Author author2 = new Author();
        author1.setAuthor_id(1);
        author1.setForename("Stephen");
        author1.setLastname("King");
        author2.setAuthor_id(2);
        author2.setForename("Bram");
        author2.setLastname("Stoker");
        allAuthors.put(1,author1);
        allAuthors.put(2,author2);
    }

    @Override
    public Author getAuthorById(int id) {
        return allAuthors.get(id);
    }
}
