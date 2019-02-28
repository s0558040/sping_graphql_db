package de.htw.ai.graphql_db.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    @Id
    private int author_id;
    private String forename;
    private String lastname;

    @OneToMany(mappedBy = "author",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    private Set<Book> books;

    public  Author(){}

    public Author(int author_id, String forname, String lastname, Set<Book> books)  {
        this.author_id = author_id;
        this.forename = forname;
        this.lastname = lastname;
        this.books = books;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Book> getBooks() {
        if(books == null){
            books = new HashSet<>();
        }
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
        if(books != null){
            books.forEach(a -> a.setAuthor(this));
        }
    }

    public void addBook(Book book){
        if(books == null){
            books = new HashSet<>();
        }
        books.add(book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", forename='" + forename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", books=" + books +
                '}';
    }
}
