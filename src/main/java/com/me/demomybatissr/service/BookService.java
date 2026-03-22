package com.me.demomybatissr.service;

import com.me.demomybatissr.model.entity.Book;
import com.me.demomybatissr.model.request.BookRequest;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks(Integer page, Integer size);

    Book getBookById(Long bookId);

    Book saveBook(BookRequest request);
}
