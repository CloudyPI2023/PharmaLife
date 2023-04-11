package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
