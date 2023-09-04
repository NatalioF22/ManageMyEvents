package com.nataliogomes.eventmanager;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

public class EventUtility {


    public static Event createEvent(String name, String description, String location, String type, String website, Date date) {
        Event event = new Event();
        event.setId(UUID.randomUUID().toString());  // Generate a random UUID
        event.setEventName(name);
        event.setEventDescription(description);
        event.setEventLocation(location);
        event.setEventType(type);
        event.setEventWebsite(website);
        event.setEventDate(date);
        return event;
    }


    }

