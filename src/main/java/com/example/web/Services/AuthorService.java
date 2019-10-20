package com.example.web.Services;

import com.example.web.Domains.Author;
import com.example.web.Services.Interfaces.DAO;
import com.mongodb.client.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class AuthorService implements DAO<Author> {

    @Autowired
    MongoTemplate mongoTemplate;

    private static final String COLLECTION = "Authors";

    public Set<String> getCollections() {
        return this.mongoTemplate.getCollectionNames();
    }
    @Override
    public Optional<Author> findById(long id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Author author = this.mongoTemplate.findOne(query, Author.class);
        Optional<Author> optionalAuthor = Optional.ofNullable(author);
        return optionalAuthor;
    }

    @Override
    public List<Author> getAll() {
        return this.mongoTemplate.findAll(Author.class, COLLECTION);
    }

    @Override
    public String create(Author author) {
        if(author != null) {
            this.mongoTemplate.save(author);
            return author.getId();
        }
        return "";
    }

    @Override
    public Author update(Author author) {
        this.mongoTemplate.save(author);
        return author;
    }

    @Override
    public Author delete(Author author) {
        this.mongoTemplate.remove(author);
        return author;
    }
}
