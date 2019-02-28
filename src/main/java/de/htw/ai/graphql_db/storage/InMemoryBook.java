package de.htw.ai.graphql_db.storage;

import de.htw.ai.graphql_db.pojo.Author;
import de.htw.ai.graphql_db.pojo.Book;
import de.htw.ai.graphql_db.pojo.Publisher;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryBook implements BookDAO {
    private Map<Integer,Book> allBooks;

    public InMemoryBook(){
        allBooks = new HashMap<>();
        initHashMap();
    }

    private void initHashMap(){
        Book book1 = new Book();
        Book book2 = new Book();
        Author author1 = new Author();
        Author author2 = new Author();
        Publisher publisher1 = new Publisher();
        Publisher publisher2 = new Publisher();

        author1.setAuthor_id(1);
        author1.setForename("Stephen");
        author1.setLastname("King");
        author2.setAuthor_id(2);
        author2.setForename("Bram");
        author2.setLastname("Stoker");

        publisher1.setPublisher_id(1);
        publisher1.setCompany_name("Bastei Lübbe AG");
        publisher1.setZip(51063);
        publisher1.setCity("Köln");
        publisher2.setPublisher_id(2);
        publisher2.setCompany_name("Anaconda Verlag GmbH");
        publisher2.setZip(50827);
        publisher2.setCity("Köln");

        book1.setIsbn(1);
        book1.setTitle("Shinig");
        book1.setPages(548);
        book1.setAuthor(author1);
        book1.setPublisher(publisher1);
        book2.setIsbn(2);
        book2.setTitle("Dracular");
        book2.setPages(469);
        book2.setAuthor(author2);
        book2.setPublisher(publisher2);

        allBooks.put(book1.getIsbn(),book1);
        allBooks.put(book2.getIsbn(), book2);
    }

    @Override
    public Book getBookById(int id) {
        return allBooks.get(id);
    }

    @Override
    public Book getBookByTitle(String title) {
        return null;
    }
}
