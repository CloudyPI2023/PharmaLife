package tn.esprit.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "Command")
public class Command implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCommand")
    private Integer idCommand;
    private String StatusCommand;
    private LocalDate DateCommand;
    private String ShippingAddressCommand;

    //NoSQL
    private Integer idUser;

    @OneToOne(mappedBy="commandPurchase")
    private Purchase purchaseCommand;

    @ManyToOne
    DeliveryPerson deliveryPerson;

}
