package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
