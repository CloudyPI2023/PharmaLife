package tn.esprit.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Article;
import tn.esprit.Repositories.ArticleRepository;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Slf4j
@Service
public class ArticleService implements  IArticleService {
    private final ArticleRepository articleRepository;

    @Override
    public Article addArticle(Article a) {

        return articleRepository.save(a);

    }



    @Override
    public Article editArticle(Article a)  throws RuntimeException {

        if (a.getIdArticle() == null) {
            throw new IllegalArgumentException("Article ID cannot be null");
        }
        try {
            return articleRepository.save(a);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update article", e);
        }
    }
    @Override
    public void deleteArticle(Long idArticle) {
        Optional<Article> article = articleRepository.findById(idArticle);

        article.ifPresent(a -> {
            articleRepository.delete(a);
            log.info("Article with id " + idArticle + " has been deleted");
        });

    }
    @Override
    public List<Article> retrieveAll() {
        return articleRepository.findAll();
    }


}