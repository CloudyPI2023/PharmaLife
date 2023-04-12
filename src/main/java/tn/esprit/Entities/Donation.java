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
@Builder
@Table( name = "Donation")
public class Donation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDonation")
    private Integer idDonation;
    private String NameDonation;
    private String DescriptionDonation;
    private Integer QuantityDonation;
    private LocalDate DateDonation;
    private String ImageDonation;
    @Enumerated(EnumType.STRING)
    private DonationRequestType DonationType;

    //NoSQL
    private Integer idRequest;

    @ManyToOne
    User userDonation;


}
