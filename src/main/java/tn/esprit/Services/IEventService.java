package tn.esprit.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entities.Event;

import java.util.List;

public interface IEventService  {

    Event addEvent(Event p);

    Event editEvent(Event p)  throws RuntimeException;

    void deleteEvent(Long idEvent);

    List<Event> retrieveAll();
}
