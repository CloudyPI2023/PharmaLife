package tn.esprit.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "Comment")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idComment")
    private Integer idComment;
    private String DescriptionComment;
    private LocalDate DateComment;
    //NoSQL
    private Integer idUser;

    @ManyToOne
    Article article;

    @ManyToOne
    Product productComment;


}
