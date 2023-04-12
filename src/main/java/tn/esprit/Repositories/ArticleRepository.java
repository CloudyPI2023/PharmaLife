package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entities.Article;

public interface ArticleRepository  extends JpaRepository<Article, Long> {

}
