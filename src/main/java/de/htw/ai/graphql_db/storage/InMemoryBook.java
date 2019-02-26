package de.htw.ai.graphql_db.storage;

import de.htw.ai.graphql_db.pojo.Author;
import de.htw.ai.graphql_db.pojo.Book;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryBook implements BookDAO {
    private Map<Integer,Book> allBooks;

    public InMemoryBook(){
        allBooks = new HashMap<>();
        allBooks.put(1,new Book(1,"Shinig",548,new Author(1,"Stephen", "King")));
        allBooks.put(2, new Book(2,"Dracular",469,new Author(2,"Bram","Stoker")));
    }

    @Override
    public Book getBookById(int id) {
        return allBooks.get(id);
    }
}
