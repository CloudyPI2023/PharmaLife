package tn.esprit.Entities;


import javax.validation.constraints.*;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import java.util.Date;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table( name = "User")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUser")
    private Integer idUser;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;


    private String address;


    private String city;


    private String password;

    @Transient
    private Integer age;

    @Temporal(TemporalType.DATE)
    private Date birthDate;


    @CreationTimestamp
    @Column(updatable = false,nullable=true)
    private LocalDateTime createdAt;



    @Enumerated(EnumType.STRING)
    private Role role;


    @Enumerated(EnumType.STRING)
    private Gender gender;

    //Associations

    @OneToMany(mappedBy="userReservation")
    private Set<Reservation> ReservationsUser;

    @OneToMany(mappedBy="userDonation")
    private Set<Donation> DonationsUser;

    @OneToMany(mappedBy="userArticle")
    private Set<Article> ArticleUser;

    @OneToMany(mappedBy="userProduct")
    private Set<Product> ProductsUser;



}
