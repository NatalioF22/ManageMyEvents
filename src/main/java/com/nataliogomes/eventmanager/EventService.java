package com.nataliogomes.eventmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public Optional<Event> getEvent(String id) {
        return repository.getEventById(id);
    }

    public Event addEvent(Event event) {
        try {
            return repository.save(event);
        } catch(Exception e) {
            // Log exception here
            e.printStackTrace();
        }
        return repository.save(event);
    }
    public void deleteEvent(String id) {
        repository.deleteById(id);
    }




    // Add more methods for CRUD operations
}
