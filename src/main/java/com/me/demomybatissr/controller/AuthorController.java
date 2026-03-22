package com.me.demomybatissr.controller;

import com.me.demomybatissr.model.entity.Author;
import com.me.demomybatissr.model.request.AuthorRequest;
import com.me.demomybatissr.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return authorService.getAllAuthors(page, size);
    }

    @GetMapping("/{author-id}")
    public Author getAuthorById(@PathVariable("author-id") Long authorId) {
        return authorService.getAuthorById(authorId);
    }

    @PostMapping
    public Author saveAuthor(@RequestBody AuthorRequest request) {
        return authorService.saveAuthor(request);
    }

}
