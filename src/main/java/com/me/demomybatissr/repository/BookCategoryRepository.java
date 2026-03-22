package com.me.demomybatissr.repository;
import com.me.demomybatissr.model.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookCategoryRepository {

    @Results(id = "bookCategoryMapper", value = {
            @Result(property = "categoryId", column = "category_id")
    })
    @Select("""
        SELECT *
        FROM book_category bc
                 INNER JOIN categories c
                            ON bc.category_id = c.category_id
        WHERE book_id = #{bookId};
    """)
    List<Category> getCategoriesByBookId(Long bookId);

    @ResultMap("bookCategoryMapper")
    @Insert("""
        INSERT INTO book_category VALUES (#{bookId}, #{categoryId});
    """)
    void insertBookCategory(Long bookId, Long categoryId);

}
