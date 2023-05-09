package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import tn.esprit.Entities.Event;
import tn.esprit.Entities.Reservation;
import tn.esprit.Entities.ReservationCount;
import tn.esprit.Entities.User;
import tn.esprit.Repositories.EventRepository;
import tn.esprit.Repositories.ReservationRepository;
import tn.esprit.Repositories.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor

public class ReservationService implements IReservationService {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;
    @Override
    public Reservation addReservation(Reservation d) {

        Random rand = new Random();
        Optional<Event> currentEvent=eventRepository.findById(d.getIdEvent());
        Optional<User> currentUser=userRepository.findById(d.getIdUser());
        System.out.println(currentUser.get().getEmail()+currentUser.get().getFirstName()+currentUser.get().getLastName());
        if(currentEvent.isPresent()&&currentUser.isPresent()){

            int alea = rand.nextInt(900) + 100; // generates a random number between 100 and 999
            d.setCodeReservation(alea);
            d.setEvent(currentEvent.get());
            d.setUserReservation(currentUser.get());
            d.setDateReservation(LocalDate.now());
            System.out.println(alea);

           emailService.sendEmail(currentUser.get().getEmail(),"Reservation is now confirmed",
                    "Dear "+currentUser.get().getFirstName()+" "+currentUser.get().getLastName()+"\n"+"Thank you for your booking for the event"+currentEvent.get().getNameEvent()+"\n" +
                            " with code "+alea+"\n"+
                            "PharmaLife cloudypi");
        }


        return reservationRepository.save(d);
    }

    @Override
    public Reservation updateReservation(Reservation d) {
        return reservationRepository.save(d);
    }

    @Override
    public void deleteReservation(Integer idReservation) {
        reservationRepository.deleteById(idReservation);
    }



    @Override
    public List<Reservation> retrieveAllReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }



    @Override
    public Reservation retrieveReservation(Integer idReservation) {
        return reservationRepository.findById(idReservation).get();
    }

    public List<Object[]> getReservationsPerEvent() {
        return reservationRepository.getReservationsPerEvent();
    }







}
