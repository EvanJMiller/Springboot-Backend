package com.example.web.Services;

import com.example.web.Domains.Article;
import com.example.web.Services.Interfaces.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArticleService implements DAO<Article> {
    @Autowired
    MongoTemplate mongoTemplate;

    private static final String COLLECTION = "Articles";

    @Override
    public Optional<Article> findById(long id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Article article = this.mongoTemplate.findOne(query, Article.class, COLLECTION);
        Optional<Article> optionalArticle = Optional.ofNullable(article);
        return optionalArticle;

    }

    @Override
    public List<Article> getAll() {
        return this.mongoTemplate.findAll(Article.class, COLLECTION);
    }

    @Override
    public String create(Article article) {
        if(article != null) {
            this.mongoTemplate.save(article, COLLECTION);
            return article.getId();
        }
        return "";
    }

    @Override
    public Article update(Article article) {
        Query query = new Query(Criteria.where("_id").is(article.getId()));
        Article foundArticle = this.mongoTemplate.findOne(query, Article.class, COLLECTION);
        if(foundArticle == null){
            System.out.println("Attmepting to update article, not found, creating new article");
        }
        this.mongoTemplate.save(article, COLLECTION);
        return article;
    }

    @Override
    public Article delete(Article article) {
        this.mongoTemplate.remove(article, COLLECTION);
        System.out.println("Deleting Article");
        return article;
    }
}
