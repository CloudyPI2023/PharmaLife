package tn.esprit.Entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table( name = "Request")
public class Request implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idRequest")
    private Integer idRequest;
    private String NameRequest;
    private String DescriptionRequest;
    @Enumerated(EnumType.STRING)
    private DonationRequestType RequestType;

    @ManyToOne
    Association association;


}
