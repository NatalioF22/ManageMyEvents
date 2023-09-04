package com.nataliogomes.eventmanager;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(collection = "eventmanager")
public class Event {

    @Id
    private String id = UUID.randomUUID().toString();
    private String eventName, eventDescription, eventLocation, eventType, eventWebsite;
    private Date eventDate;

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventWebsite() {
        return eventWebsite;
    }

    public void setEventWebsite(String eventWebsite) {
        this.eventWebsite = eventWebsite;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
// getters and setters
}
