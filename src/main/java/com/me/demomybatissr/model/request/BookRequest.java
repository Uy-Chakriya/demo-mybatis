package com.me.demomybatissr.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String title;
    private Instant publishedDate;
    private Long authorId;
    private List<Long> categoryIds;
}
