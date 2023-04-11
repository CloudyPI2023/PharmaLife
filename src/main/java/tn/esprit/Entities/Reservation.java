package tn.esprit.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "Reservation")
@Builder
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idReservation")
    private Integer idReservation;
    private LocalDate DateReservation;

    @ManyToOne
    User userReservation;

    @ManyToOne
    Event event;


}
