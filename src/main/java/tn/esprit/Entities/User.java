package tn.esprit.Entities;


import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table( name = "User")
public class User implements Serializable, UserDetails {


    private static final long serialVersionUID =1L;
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUser")
    private Integer idUser;


    @NotNull(message = "First Name cannot be empty")
    @Column(length=50, nullable=false, unique=false)
    private String firstName;


    @Column(length=50, nullable=false, unique=false)
    @NotNull(message = "Last Name cannot be empty")
    private String lastName;


    @NotNull(message = "Email cannot be empty")
    @Email(message = "Please enter a valid email address")
    @Column(unique = true,nullable=false)
    private String email;


    @NotNull(message = "Phone number cannot be empty")
   // @Pattern(regexp = "\\d{8}", message = "Phone number must be 8 digits")
    @Column(nullable=false)
    private String phoneNumber;


    @Transient
    // @Formula("YEAR(CURDATE()) - YEAR(BIRTHDATE)")
    private Integer age;

    // @Temporal(TemporalType.DATE)
    @Column(nullable=false)

    private LocalDate birthDate;
    @Column(nullable=false)

    private String imageUser;


    @NotNull(message = "Address cannot be empty")
    @Column(nullable=false)
    private String address;


    @NotNull(message = "City cannot be empty")
    @Column(nullable=false)
    private String city;

    @NotNull(message = "Password cannot be empty")
    @Length(min = 7, message = "Password should be atleast 7 characters long")
    @Column(nullable=false)
    private String password;


    @CreationTimestamp
    @Column(updatable = false,nullable=true)
    private LocalDateTime createdAt;

    private Boolean locked = false;

    private Boolean enabled = false;


    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Gender gender;


    @Column(nullable=false)
    private Integer loginAttempts = 0;

    @Column
    private LocalDateTime lockTime;


    private Boolean activationStatus= false;

    @Column
    private LocalDateTime lastLoginTime;

    //Associations

    @OneToMany(mappedBy="userReservation")
    private Set<Reservation> ReservationsUser;

    @OneToMany(mappedBy="userDonation")
    private Set<Donation> DonationsUser;

    @OneToMany(mappedBy="userArticle")
    private Set<Article> ArticleUser;

    @OneToMany(mappedBy="userProduct")
    private Set<Product> ProductsUser;



///constructeur
public User(String firstName, String lastName, String email, String phoneNumber, LocalDate birthDate, String address,
            String city, String password, Role role, Gender gender,String imageUser) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.birthDate = birthDate;
    this.address = address;
    this.city = city;
    this.password = password;
    this.role = role;
    this.gender = gender;
    this.imageUser=imageUser;
}

    //
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }





}
