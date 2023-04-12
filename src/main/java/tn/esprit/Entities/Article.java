package tn.esprit.Entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table( name = "Article")
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idArticle")
    private Integer idArticle;
    private String NameArticle;
    private String DescriptionArticle;
    private String ImageArticle;
    private LocalDate DateArticle;


    @ManyToOne
    User userArticle;

    @OneToMany(mappedBy="article")
    private Set<Comment> CommentsArticle;


}
