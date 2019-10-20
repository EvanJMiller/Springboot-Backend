package com.example.web.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class SampleController {

    @GetMapping("HelloWorld")
    public String getHelloWorld(){
        System.out.println("HelloWorld Controller hit");
        return "Hello World";
    }

    @GetMapping("Collections")
    public String getCollections(){
        System.out.println("HelloWorld Controller hit");
        return "Hello World";
    }
}
