package de.htw.ai.graphql_db.storage;

import de.htw.ai.graphql_db.pojo.Publisher;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InMemoryPublisher implements PublisherDAO {
    private Map<Integer,Publisher> allPublisher;

    public InMemoryPublisher(){
        allPublisher = new HashMap<>();
        initPublisherMap();
    }

    private void initPublisherMap(){
        Publisher publisher1 = new Publisher();
        Publisher publisher2 = new Publisher();

        publisher1.setPublisher_id(1);
        publisher1.setCompany_name("Bastei Lübbe AG");
        publisher1.setZip(51063);
        publisher1.setCity("Köln");
        publisher2.setPublisher_id(2);
        publisher2.setCompany_name("Anaconda Verlag GmbH");
        publisher2.setZip(50827);
        publisher2.setCity("Köln");

        allPublisher.put(publisher1.getPublisher_id(),publisher1);
        allPublisher.put(publisher2.getPublisher_id(),publisher2);
    }

    @Override
    public Publisher getPublisherById(int id) {
        return null;
    }

    @Override
    public Publisher getPublisherByName(String name) {
        return null;
    }
}
