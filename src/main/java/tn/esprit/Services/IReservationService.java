package tn.esprit.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entities.Event;
import tn.esprit.Entities.Reservation;

import java.util.List;

public interface IReservationService  {
    Reservation addReservation(Reservation p);

    Reservation editReservation(Reservation p)  throws RuntimeException;

    void deleteReservation(Long idReservation);

    List<Reservation> retrieveAll();
}
