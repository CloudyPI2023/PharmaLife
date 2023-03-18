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
@Table( name = "Product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProduct")
    private Integer idProduct;
    private String ReferenceProduct;
    private String NameProduct;
    private Strig ImageProduct;
    private String DescriptionProduct;
    private Float PriceProduct;
    private Integer QuantityProduct;
    private Integer AvailibilityProduct;
    private LocalDate ExpirationDateProduct;

    @ManyToOne
    User userProduct;

    @ManyToOne
    Category categoryProduct;

    @ManyToOne
    Gift giftProduct;

    @OneToMany(mappedBy="product")
    private Set<Reclamation> ReclamationsProduct;

    @OneToMany(mappedBy="productComment")
    private Set<Comment> CommentProduct;
}
