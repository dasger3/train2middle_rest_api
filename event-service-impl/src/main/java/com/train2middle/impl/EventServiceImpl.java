package com.train2middle.impl;

import com.train2middle.api.EventService;
import com.train2middle.dto.Event;
import com.train2middle.dto.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Long id, Event event) {
        Event tmp = getEvent(id);
        event.setId(tmp.getId());
        return eventRepository.save(event);
    }

    @Override
    public Event getEvent(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isEmpty()) throw new ObjectNotFoundException(id,"Event");
        return event.get();
    }

    @Override
    public void deleteEvent(Long id) {
        getEvent(id);
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getAllEventsByTitle(String title) {
        return eventRepository.findAllByTitle(title);
    }
}
