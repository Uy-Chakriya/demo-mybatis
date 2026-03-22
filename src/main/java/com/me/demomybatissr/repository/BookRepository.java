package com.me.demomybatissr.repository;

import com.me.demomybatissr.model.entity.Book;
import com.me.demomybatissr.model.request.BookRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookRepository {

    @Results(id = "bookMapper", value = {
            @Result(property = "bookId", column = "book_id"),
            @Result(property = "publishedDate", column = "published_date"),
            @Result(property = "author", column = "author_id", one = @One(select = "com.me.demomybatissr.repository.AuthorRepository.getAuthorById")),
            @Result(property = "categories", column = "book_id", many = @Many(select = "com.me.demomybatissr.repository.BookCategoryRepository.getCategoriesByBookId"))
    })
    @Select("""
        SELECT * FROM books LIMIT #{size} OFFSET #{offset};
    """)
    List<Book> getAllBooks(int offset, Integer size);

    @ResultMap("bookMapper")
    @Select("""
        SELECT * FROM books WHERE book_id = #{bookId}
    """)
    Book getBookById(Long bookId);

    @ResultMap("bookMapper")
    @Select("""
        INSERT INTO books VALUES (default, #{req.title}, #{req.publishedDate}, #{req.authorId}) RETURNING *;
    """)
    Book saveBook(@Param("req") BookRequest request);


}
