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
@Table( name = "Gift")
public class Gift implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idGift")
    private Integer idGift;
    private LocalDate BeginsAtGift;
    private LocalDate EndsAtGift;
    //NoSQL
    private Integer idUser;

    @OneToMany(mappedBy="giftProduct")
    private Set<Product> ProductsGift;


}
