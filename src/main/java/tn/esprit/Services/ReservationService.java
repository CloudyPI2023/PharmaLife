package tn.esprit.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Reservation;
import tn.esprit.Repositories.ReservationRepository;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Slf4j
@Service
public class ReservationService implements  IReservationService {
    private final ReservationRepository reservationRepository;

    @Override
    public Reservation addReservation(Reservation p) {
        if (p.getDateReservation()== null) {
            throw new IllegalArgumentException("Reservation must have a date !");
        }
        try {
            return reservationRepository.save(p);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add Reservation", e);
        }
    }

    @Override
    public Reservation editReservation(Reservation p)  throws RuntimeException {

        if (p.getIdReservation() == null) {
            throw new IllegalArgumentException("Reservation ID cannot be null");
        }
        try {
            return reservationRepository.save(p);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update Reservation", e);
        }
    }
    @Override
    public void deleteReservation(Long idReservation) {
        Optional<Reservation> reservation = reservationRepository.findById(idReservation);

        reservation.ifPresent(p -> {
            reservationRepository.delete(p);
            log.info("Reservation with id " + idReservation + " has been deleted");
        });

    }
    @Override
    public List<Reservation> retrieveAll() {
        return reservationRepository.findAll();
    }


}
