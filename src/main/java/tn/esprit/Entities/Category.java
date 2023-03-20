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
@Table( name = "Category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCategory")
    private Integer idCategory;
    private String NameCategory;
    private String DescriptionCategory;


    @OneToMany(mappedBy="categoryProduct")
    private Set<Product> ProductsCategory;
}
