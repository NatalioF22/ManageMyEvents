package com.nataliogomes.eventmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private EventRepository repository;

    private static int idCounter = 0;  // Unique ID counter

    @Override
    public void run(ApplicationArguments args) {
        // Modified event
        Event event1 = createEvent("Future of AI Summit", "A discussion on the latest advancements and ethical considerations in AI.",
                "San Francisco, CA", "Summit", "http://futureofaisummit.com", new Date());

        // New and creative event
        Event event2 = createEvent("Intergalactic Culinary Fiesta", "A cooking competition featuring chefs from various planets.",
                "Mars Culinary Center", "Cook-off", "http://intergalacticculinaryfiesta.space", new Date());

        repository.save(event1);
        repository.save(event2);


        // Deleted event with ID 1 for some reason.
        // Note: This line might throw an exception if there is no such ID in the repository.

    }

    private Event createEvent(String name, String description, String location, String type, String website, Date date) {
        Event event = new Event();
        event.setId(String.valueOf(++idCounter));  // Increment the counter before assigning
        event.setEventName(name);
        event.setEventDescription(description);
        event.setEventLocation(location);
        event.setEventType(type);
        event.setEventWebsite(website);
        event.setEventDate(date);
        return event;
    }
}
