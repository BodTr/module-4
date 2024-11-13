package com.spring.books_management.controller;


import com.spring.books_management.model.entity.AuthorEntity;
import com.spring.books_management.service.impl.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorEntity> getAllAuthors() {
        List<AuthorEntity> authorEntities = (List<AuthorEntity>) authorService.findAll();
        return authorEntities;
    }
}
