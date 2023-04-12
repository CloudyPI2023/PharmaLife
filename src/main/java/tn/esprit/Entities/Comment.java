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
