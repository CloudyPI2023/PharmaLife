package tn.esprit.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@CrossOrigin
@Table( name = "DeliveryPerson")
public class DeliveryPerson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDeliveryP")
    private Integer idDeliveryP;

    private String nomPrenomDeliveryP;

    private Integer CINDeliveryP;

    private Integer phoneNumberDeliveryP;

    private String addressDeliveryP;

    private String emailDeliveryP;

    @Temporal(TemporalType.DATE)
    private Date hireDateDeliveryP;

    @Enumerated(EnumType.STRING)
    private VehiculeType vehiculeType;

    private String deliveryArea;

    private Boolean availabilityDeliveryP;



    //NoSQL
    private Integer idUser;

    @OneToMany(mappedBy="deliveryPerson")
    @JsonIgnore
    private Set<Order> OrdersD;

}
