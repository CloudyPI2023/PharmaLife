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
@Table( name = "Order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idOrder")
    private Integer idOrder;
    private String StatusOrder;
    private LocalDate DateOrder;
    private String ShippingAddressOrder;

    //NoSQL
    private Integer idUser;

    @OneToOne(mappedBy="orderPurchase")
    private Purchase purchaseOrder;

    @ManyToOne
    DeliveryPerson deliveryPerson;

}
