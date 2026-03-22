package com.me.demomybatissr.controller;

import com.me.demomybatissr.model.entity.Book;
import com.me.demomybatissr.model.request.BookRequest;
import com.me.demomybatissr.model.response.ApiResponse;
import com.me.demomybatissr.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Book>>> getAllBooks(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {

        List<Book> books =  bookService.getAllBooks(page, size);

        ApiResponse<List<Book>> response = ApiResponse.<List<Book>>builder().success(true).status(HttpStatus.OK).message("Books fetched successfully").payload(books).timestamp(Instant.now()).build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{book-id}")
    public Book getBookById(@PathVariable("book-id") Long bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping
    public Book saveBook(@RequestBody BookRequest request) {

        return bookService.saveBook(request);
    }

}
