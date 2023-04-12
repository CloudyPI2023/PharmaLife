package tn.esprit.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
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
    Product product;



}
