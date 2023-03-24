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
@Table( name = "Reclamation")
public class Reclamation implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idReclamation")
    private Integer idReclamation;
    private String DescriptionReclamation;
    private LocalDate DateReclamation;
    //NoSQL
    private Integer idUser;
    @ManyToOne
    User userProduct;

    @ManyToOne
    Product product;


}
