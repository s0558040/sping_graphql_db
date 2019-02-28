package de.htw.ai.graphql_db.pojo;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    private int isbn;
    private String title;
    private int pages;

    @ManyToOne
    @JoinColumn(name="author")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher")
    private Publisher publisher;

    public Book(){}

    public Book(int isbn, String title, int pages, Author author, Publisher publisher) {
        this.isbn = isbn;
        this.title = title;
        this.pages = pages;
        this.author = author;
        this.publisher = publisher;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Author getAuthor(){return this.author;}

    public void setAuthor(Author author){this.author = author;}

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
