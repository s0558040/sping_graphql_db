package de.htw.ai.graphql_db.storage;

import de.htw.ai.graphql_db.pojo.Publisher;

public interface PublisherDAO {
    Publisher getPublisherById(int id);
    Publisher getPublisherByName(String name);
}
