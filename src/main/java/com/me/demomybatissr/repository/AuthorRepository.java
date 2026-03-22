package com.me.demomybatissr.repository;
import com.me.demomybatissr.model.entity.Author;
import com.me.demomybatissr.model.request.AuthorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthorRepository {

    @Results(id = "authorMapper", value = {
            @Result(property = "authorId", column = "author_id")
    })
    @Select("""
        SELECT * FROM authors LIMIT #{size} OFFSET #{offset};
    """)
    List<Author> getAllAuthors(Integer offset, Integer size);

    @ResultMap("authorMapper")
    @Select("""
        SELECT * FROM authors WHERE author_id = #{authorId}
    """)
    Author getAuthorById(Long authorId);

    @ResultMap("authorMapper")
    @Select("""
        INSERT INTO authors VALUES (default, #{req.name}, #{req.gender}) RETURNING *;
    """)
    Author saveAuthor(@Param("req") AuthorRequest request);
}
