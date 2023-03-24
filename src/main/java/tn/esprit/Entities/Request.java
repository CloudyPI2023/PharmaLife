package tn.esprit.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
