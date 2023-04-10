package tn.esprit.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "Category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCategory")
    private Integer idCategory;
    @NonNull
    @Column(unique = true)
    private String NameCategory;
    @NonNull
    private String DescriptionCategory;
    private boolean archived;


    @OneToMany(mappedBy="categoryProduct",cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Product> ProductsCategory;
}
