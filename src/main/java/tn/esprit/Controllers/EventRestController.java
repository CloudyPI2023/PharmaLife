package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Event;
import tn.esprit.Services.IEventService;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class EventRestController {
    private  final IEventService eventService;

    // http://localhost:8082/all-events
    @GetMapping("/all-events")
    public List<Event> getEvents() {
        return eventService.retrieveAll();
    }

    // http://localhost:8082/add-event
    @PostMapping("/add-event")
    public Event addEvent(@RequestBody Event p) {
        return eventService.addEvent(p);
    }

    // http://localhost:8082/edit-event
    @PutMapping("/edit-event")
    public Event editEvent(@RequestBody Event p) {
        return eventService.editEvent(p);
    }

    // http://localhost:8082/delet-event/id
    @DeleteMapping("/delete-event/{idEvent}")
    public void deleteEvent(@PathVariable("idEvent") Long id) {
        eventService.deleteEvent(id);
    }
}