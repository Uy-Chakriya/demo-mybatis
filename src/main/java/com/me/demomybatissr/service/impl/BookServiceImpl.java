package com.me.demomybatissr.service.impl;

import com.me.demomybatissr.model.entity.Book;
import com.me.demomybatissr.model.request.BookRequest;
import com.me.demomybatissr.repository.BookCategoryRepository;
import com.me.demomybatissr.repository.BookRepository;
import com.me.demomybatissr.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookCategoryRepository bookCategoryRepository;

    public BookServiceImpl(BookRepository bookRepository, BookCategoryRepository bookCategoryRepository) {
        this.bookRepository = bookRepository;
        this.bookCategoryRepository = bookCategoryRepository;
    }

    @Override
    public List<Book> getAllBooks(Integer page, Integer size) {
        int offset = (page - 1) * size;
        return bookRepository.getAllBooks(offset, size);
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.getBookById(bookId);
    }

    @Override
    public Book saveBook(BookRequest request) {

        Book book = bookRepository.saveBook(request);

        for(Long categoryId : request.getCategoryIds()) {
            bookCategoryRepository.insertBookCategory(book.getBookId(), categoryId);
        }

        return bookRepository.getBookById(book.getBookId());
    }
}
