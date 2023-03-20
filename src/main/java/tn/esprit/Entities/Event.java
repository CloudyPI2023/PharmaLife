package tn.esprit.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "Event")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEvent")
    private Integer idEvent;
    private String NameEvent;
    private String DescriptionEvent;
    private String LocationEvent;
    private String ImageEvent;
    private LocalDate BeginsAtEvent;
    private LocalDate EndsAtEvent;

    //NoSQL
    private Integer idAssociation;


    @OneToMany(mappedBy="event")
    private Set<Reservation> ReservationsEvent;
}
