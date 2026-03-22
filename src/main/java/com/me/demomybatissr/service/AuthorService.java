package com.me.demomybatissr.service;

import com.me.demomybatissr.model.entity.Author;
import com.me.demomybatissr.model.request.AuthorRequest;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors(Integer page, Integer size);

    Author getAuthorById(Long authorId);

    Author saveAuthor(AuthorRequest request);
}
