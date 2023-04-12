package tn.esprit.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table( name = "Association")
public class Association implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAssocation")
    private int idAssocation;
    private String AssociationName;
    private String AdressAssociation;
    private String EmailAssocation;
    private String LogoAssocation;
    private String DescriptionAssocation;
    private String PhoneNumberAssocation;
    private String CountryAssocation;


    @OneToMany(mappedBy="association")
    private Set<Request> RequestsAssociation;


}
