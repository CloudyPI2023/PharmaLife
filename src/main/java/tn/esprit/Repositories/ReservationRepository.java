package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.Entities.Reservation;

import java.util.List;

public interface ReservationRepository  extends CrudRepository<Reservation, Integer> {


    @Query("SELECT e.idEvent, e.nameEvent, COUNT(r.idReservation) FROM Event e LEFT JOIN e.ReservationsEvent r GROUP BY e.idEvent")
    List<Object[]> getReservationsPerEvent();



}
