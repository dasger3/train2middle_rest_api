package com.train2middle.rest.controller;

import com.train2middle.api.EventService;
import com.train2middle.dto.Event;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

import java.util.List;

@Api(value = "Event controller", description = "REST APIs related to Event entity")
@RestController
@RequestMapping("event")
@RequiredArgsConstructor
public class EventServiceController {

    private final EventService eventService;

    @ApiOperation(value = "Get list of Events in the System ", response = Iterable.class, tags = "getAllEvents")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 204, message = "Your action was successful"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/")
    public ResponseEntity<?> getAllEvents() {
        List<Event> result = eventService.getAllEvents();
        return (result.isEmpty()) ? ResponseEntity.notFound().build() : ResponseEntity.ok(result);
    }

    @ApiOperation(value = "Get event by id", response = Event.class, tags = "getEventById")
    @GetMapping("/{id}")
    public ResponseEntity<Event> findEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEvent(id));
    }

    @ApiOperation(value = "Save event", response = Event.class, tags = "saveEvent")
    @PostMapping
    public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.createEvent(event));
    }

    @ApiOperation(value = "Update event", response = Event.class, tags = "updateEvent")
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return ResponseEntity.ok(eventService.updateEvent(id, event));
    }

    @ApiOperation(value = "Delete event", response = ResponseEntity.class, tags = "deleteEventById")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEventById(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "Find events by title", response = Iterable.class, tags = "getAllEventsByTitle")
    @GetMapping("/title/{title}")
    public ResponseEntity<?> getAllEventsByTitle(@PathVariable String title) {
        return ResponseEntity.ok(eventService.getAllEventsByTitle(title));
    }
}
