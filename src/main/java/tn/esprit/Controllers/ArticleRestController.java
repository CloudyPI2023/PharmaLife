package tn.esprit.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Article;
import tn.esprit.Services.IArticleService;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class ArticleRestController {

    private  final IArticleService articleService;

    // http://localhost:8082/all-articles
    @GetMapping("/all-articles")
    public List<Article> getArticles() {
        return articleService.retrieveAll();
    }

    // http://localhost:8082/add-article
    @PostMapping("/add-article")
    public Article addArticle(@RequestBody Article a) {
        return articleService.addArticle(a);
    }

    // http://localhost:8082/edit-article
    @PutMapping("/edit-article")
    public Article editArticle(@RequestBody Article a) {
        return articleService.editArticle(a);
    }


    @PutMapping("/edit-article/{id}")
    public Article editArticle(@PathVariable("id") Long articleId, @RequestBody Article a) {
        // use articleId to retrieve and update the article
        return articleService.editArticle(a);
    }
    // http://localhost:8082/delet-article/id
    @DeleteMapping("/delete-article/{idArticle}")
    public void deleteArticle(@PathVariable("idArticle") Long id) {
        articleService.deleteArticle(id);
    }
}

