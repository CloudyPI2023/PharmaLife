package tn.esprit.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
