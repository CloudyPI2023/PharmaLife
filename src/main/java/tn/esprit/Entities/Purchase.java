package tn.esprit.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.net.Inet4Address;
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
    private Order orderPurchase;

    @ManyToOne
    User userPurchase;

    @ManyToMany
    private Set<Product> productPurchase;
}
