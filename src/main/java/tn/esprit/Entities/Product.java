package tn.esprit.Entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    private Integer expired;
   // private Integer AvailabilityProduct;


    private LocalDate expirationDateProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonIgnore
    private User userProduct;

    @ManyToOne
    private Category categoryProduct;



    @OneToMany(mappedBy="product")
    @JsonIgnore
    private Set<Reclamation> ReclamationsProduct;

    @OneToMany(mappedBy="productComment")

    private Set<Comment> CommentProduct;
}
