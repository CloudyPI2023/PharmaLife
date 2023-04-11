package tn.esprit.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Event;
import tn.esprit.Repositories.EventRepository;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Slf4j
@Service
public class EventService implements  IEventService {
    private final EventRepository eventRepository;

   // @Override
    //  public Event addEvent(Event p) {
    //  if (p.getNameEvent() == null || p.getNameEvent().isEmpty()) {
    //     throw new IllegalArgumentException("Event must have a name !");
    //   }
    //   try {
    //     return eventRepository.save(p);
    //} catch (Exception e) {
    //   throw new RuntimeException("Failed to add Event", e);
    //   }
    //   }

    @Override
    public Event addEvent(Event p) {

            return eventRepository.save(p);

    }



    @Override
    public Event editEvent(Event p)  throws RuntimeException {

        if (p.getIdEvent() == null) {
            throw new IllegalArgumentException("Event ID cannot be null");
        }
        try {
            return eventRepository.save(p);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update product", e);
        }
    }
    @Override
    public void deleteEvent(Long idEvent) {
        Optional<Event> event = eventRepository.findById(idEvent);

        event.ifPresent(p -> {
            eventRepository.delete(p);
            log.info("Event with id " + idEvent + " has been deleted");
        });

    }
    @Override
    public List<Event> retrieveAll() {
        return eventRepository.findAll();
    }


}
