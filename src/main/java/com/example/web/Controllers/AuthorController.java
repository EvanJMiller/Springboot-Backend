package com.example.web.Controllers;

import com.example.web.Domains.Author;
import com.example.web.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping(path="collections")
    public Set<String> getCollections(){
        Set<String> collections = this.authorService.getCollections();
        System.out.println(collections);
        return collections;

    }
    @PostMapping(path="create")
    public ResponseEntity<String> createAuthor(@RequestBody Author article){
        System.out.println("create");
        System.out.println(article);
        return new ResponseEntity<String>(authorService.create(article), HttpStatus.CREATED);
    }

    @PostMapping(path="/update/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") String id, @RequestBody Author article){
        System.out.println("update");
        return new ResponseEntity<Author>(authorService.update(article), HttpStatus.CREATED);
    }

    @PostMapping(path="/delete/{id}")
    public ResponseEntity<Author> deleteAuthor(@RequestBody Author article){
        System.out.println("delete");
        return new ResponseEntity<Author>(authorService.delete(article), HttpStatus.CREATED);
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<Author>> getAuthors(){
        System.out.println("all");
        return new ResponseEntity<>(authorService.getAll(), HttpStatus.CREATED);
    }

}

