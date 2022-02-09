package com.train2middle.rest.controller;

import com.train2middle.api.EventService;
import com.train2middle.dto.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("event")
@RequiredArgsConstructor
public class EventServiceController {

    private final EventService eventService;

    @GetMapping("/")
    public ResponseEntity<?> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> findEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEvent(id));
    }

    @PostMapping
    public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.createEvent(event));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return ResponseEntity.ok(eventService.updateEvent(id, event));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEventById(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?> getAllEventsByTitle(@PathVariable String title) {
        return ResponseEntity.ok(eventService.getAllEventsByTitle(title));
    }
}
