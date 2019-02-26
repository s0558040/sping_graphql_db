package de.htw.ai.graphql_db.pojo;

public class Book {
    private int isbn;
    private String title;
    private int pages;
    private Author author;

    public Book(){}

    public Book(int isbn, String title, int pages, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.pages = pages;
        this.author = author;
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

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", author=" + author +
                '}';
    }
}
