package tn.esprit.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entities.Article;

import java.util.List;

public interface IArticleService {
    Article addArticle(Article a);

    Article editArticle(Article a)  throws RuntimeException;

    void deleteArticle(Long idArticle);

    List<Article> retrieveAll();
}
