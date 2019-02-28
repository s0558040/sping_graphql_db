package de.htw.ai.graphql_db.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    private int publisher_id;
    private String company_name;
    private int zip;
    private String city;

    @OneToMany(mappedBy = "publisher",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    private Set<Book> books;

    public Publisher(){}

    public Publisher(int publisher_id, String company_name, int zip, String city, Set<Book> books) {
        this.publisher_id = publisher_id;
        this.company_name = company_name;
        this.zip = zip;
        this.city = city;
        this.books = books;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
            books.forEach(a -> a.setPublisher(this));
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
        return "Publisher{" +
                "publisher_id=" + publisher_id +
                ", company_name='" + company_name + '\'' +
                ", zip=" + zip +
                ", city='" + city + '\'' +
                ", books=" + books +
                '}';
    }
}
