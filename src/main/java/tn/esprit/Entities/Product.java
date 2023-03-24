package tn.esprit.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;
    private String ReferenceProduct;
    private String NameProduct;
    private String ImageProduct;
    private String DescriptionProduct;
    private Float PriceProduct;
    private Integer QuantityProduct;
    private Integer AvailabilityProduct;
    private LocalDate ExpirationDateProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonIgnore
    private User userProduct;

    @ManyToOne
    private Category categoryProduct;

    @ManyToOne
    private Gift giftProduct;

    @OneToMany(mappedBy="product")
    @JsonIgnore
    private Set<Reclamation> ReclamationsProduct;

    @OneToMany(mappedBy="productComment")
    private Set<Comment> CommentProduct;
}
