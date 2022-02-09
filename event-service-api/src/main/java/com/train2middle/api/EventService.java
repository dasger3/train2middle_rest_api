package com.train2middle.api;

import com.train2middle.dto.Event;

import java.util.List;

public interface EventService {

    Event createEvent(Event event);
    Event updateEvent(Long id, Event event);
    Event getEvent(Long id);
    void deleteEvent(Long id);
    List<Event> getAllEvents();
    List<Event> getAllEventsByTitle(String title);
}
