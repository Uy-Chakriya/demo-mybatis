package com.me.demomybatissr.service.impl;

import com.me.demomybatissr.model.entity.Author;
import com.me.demomybatissr.model.request.AuthorRequest;
import com.me.demomybatissr.repository.AuthorRepository;
import com.me.demomybatissr.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors(Integer page, Integer size) {

        Integer offset = (page - 1) * size;

        return authorRepository.getAllAuthors(offset, size);
    }

    @Override
    public Author getAuthorById(Long authorId) {
        return authorRepository.getAuthorById(authorId);
    }

    @Override
    public Author saveAuthor(AuthorRequest request) {
        return authorRepository.saveAuthor(request);
    }

}
