package tn.esprit.Entities;


import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table( name = "Gift")
public class Gift implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idGift")
    private Integer idGift;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "M-d-yyyy")
    private LocalDate BeginsAtGift;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "M-d-yyyy")
    private LocalDate EndsAtGift;
    //NoSQL
    private Integer idUser;
    private Integer idProduct;

    @OneToMany(mappedBy="giftProduct",cascade = CascadeType.REMOVE)
    private Set<Product> ProductsGift;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonIgnore
    private User userGift;




}
