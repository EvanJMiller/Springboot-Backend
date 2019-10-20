package com.example.web.Controllers;

import com.example.web.Domains.Article;
import com.example.web.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping(value="/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @PostMapping(path="/create")
    public ResponseEntity<String> createArticle(@RequestBody Article article){
        System.out.println("Creating Article");
        return new ResponseEntity<>(articleService.create(article), HttpStatus.CREATED);
    }

    @PostMapping(path="/update/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") String id, @RequestBody Article article){
        System.out.println("Updating Article");
        return new ResponseEntity<>(articleService.update(article), HttpStatus.CREATED);
    }

    @PostMapping(path="/delete/{id}")
    public ResponseEntity<Article> deleteArticle(@RequestBody Article article){
        System.out.println("Deleting Article");
        return new ResponseEntity<>(articleService.delete(article), HttpStatus.CREATED);
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<Article>> getArticles(){
        System.out.println("Listing Articles");
        return new ResponseEntity<>(articleService.getAll(), HttpStatus.CREATED);
    }

}
