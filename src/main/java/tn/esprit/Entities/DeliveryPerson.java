package tn.esprit.Entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table( name = "DeliveryPerson")
public class DeliveryPerson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDeliveryP")
    private Integer idDeliveryP;
    private String PhoneNumberDeliveryP;
    private String LocationDelivery;
    //NoSQL
    private Integer idUser;

    @OneToMany(mappedBy="deliveryPerson")
    private Set<Command> CommandsD;

}
