
package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.Entities.Reservation;
import tn.esprit.Services.IReservationService;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class ReservationRestController {
    private  final IReservationService reservationService;

    // http://localhost:8082/all-reservations
    @GetMapping("/all-reservations")
    public List<Reservation> getReservations() {
        return reservationService.retrieveAll();
    }

    // http://localhost:8082/add-reservation
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation p) {
        return reservationService.addReservation(p);
    }

    // http://localhost:8082/edit-reservation
    @PutMapping("/edit-reservation")
    public Reservation editReservation(@RequestBody Reservation p) {
        return reservationService.editReservation(p);
    }

    // http://localhost:8082/delet-reservation/id
    @DeleteMapping("/delete-reservation/{idReservation}")
    public void deleteReservation(@PathVariable("idReservation") Long id) {
        reservationService.deleteReservation(id);
    }
}