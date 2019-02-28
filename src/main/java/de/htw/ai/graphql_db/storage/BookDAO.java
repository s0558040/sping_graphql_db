package de.htw.ai.graphql_db.storage;

import de.htw.ai.graphql_db.pojo.Book;

public interface BookDAO {
    Book getBookById(int id);
    Book getBookByTitle(String title);
}
