package de.htw.ai.graphql_db.storage;

import de.htw.ai.graphql_db.pojo.Author;

public interface AuthorDAO {
    Author getAuthorById(int id);
}
