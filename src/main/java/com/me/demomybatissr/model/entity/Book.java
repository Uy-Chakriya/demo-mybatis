package com.me.demomybatissr.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long bookId;
    private String title;
    private Instant publishedDate;
    private Author author;
    private List<Category> categories;
}
