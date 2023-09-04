package com.nataliogomes.eventmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventRepository repository;
    @Autowired
    private EventService service;
    @Autowired
    private DataLoader dataLoader;

    @GetMapping("/")
    public String getAllEvents(Model model) {
        List<Event> events = service.getAllEvents();
        model.addAttribute("events", events);
        return "index";
    }

    @GetMapping("/events/{id}")
    public String getAnEvent(@PathVariable String id, Model model) {
        Optional<Event> event = service.getEvent(id);
        if (event.isPresent()) {
            model.addAttribute("event", event.get());
            return "event";
        } else {
            return "eventNotFound";
        }
    }

    @GetMapping("/addEvent")
    public String showForm() {
        return "addEvent";
    }

    @PostMapping("/addEvent")
    public String submitForm(@RequestParam String eventName,
                             @RequestParam String eventDescription,
                             @RequestParam String eventLocation,
                             @RequestParam String eventType,
                             @RequestParam String eventWebsite,
                             @RequestParam String eventDate) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(eventDate);
        } catch (ParseException e) {
            logger.error("Failed to parse date: {}", e.getMessage());
        }

        if (date != null) {
            Event newEvent = EventUtility.createEvent(eventName, eventDescription, eventLocation, eventType, eventWebsite, date);
            repository.save(newEvent);
        } else {
            logger.warn("Date was null. Event not saved.");
        }

        return "redirect:/events";
    }

    @GetMapping("/updateEvent/{id}")
    public String showUpdateForm(@PathVariable String id, Model model) {
        Optional<Event> event = service.getEvent(id);
        if (event.isPresent()) {
            model.addAttribute("event", event.get());
            return "updateEvent";  // This should be the name of your Thymeleaf update form template
        } else {
            return "eventNotFound";
        }
    }

    @PostMapping("/updateEvent/{id}")
    public String updateEvent(@PathVariable String id,
                              @RequestParam String eventName,
                              @RequestParam String eventDescription,
                              @RequestParam String eventLocation,
                              @RequestParam String eventType,
                              @RequestParam String eventWebsite,
                              @RequestParam String eventDate) {
        // Convert the eventDate string to Date object
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(eventDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date != null) {
            Event updatedEvent = EventUtility.createEvent(eventName, eventDescription, eventLocation, eventType, eventWebsite, date);
            updatedEvent.setId(id);  // Make sure to set the ID to update the existing event
            repository.save(updatedEvent);
        }
        return "redirect:/";
    }

    @PostMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable String id) {
        repository.deleteById(id);
        return "redirect:/";  // Redirect to the list of events
    }

}
