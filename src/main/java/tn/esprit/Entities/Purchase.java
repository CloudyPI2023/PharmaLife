package tn.esprit.Entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder

@Table( name = "Purchase")
public class Purchase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPurchase")
    private Integer idPurchase;
    private Integer QuantityPurchase;
    private Integer TotalPurchase;
    private LocalDate DatePurchase;
    private float FinalPricePurchase;
    @Enumerated(EnumType.STRING)
    private PurchaseType purchaseType;

    @OneToOne
    private Command CommandPurchase;

    @ManyToOne
    User userPurchase;

    @ManyToMany
    private Set<Product> productPurchase;
}
