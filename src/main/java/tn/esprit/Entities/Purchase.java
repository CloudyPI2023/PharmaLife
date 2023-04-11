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
    private Command commandPurchase;

    @ManyToOne
    User userPurchase;

    @ManyToMany
    private Set<Product> productPurchase;
}
