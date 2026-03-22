INSERT INTO authors (name, gender) VALUES
                                       ('J.K. Rowling', 'Female'),
                                       ('George R.R. Martin', 'Male'),
                                       ('J.R.R. Tolkien', 'Male'),
                                       ('Agatha Christie', 'Female'),
                                       ('Stephen King', 'Male');

INSERT INTO books (title, published_date, author_id)
VALUES ('A','1997-06-26', 1),
       ('B','1996-08-06', 2),
       ('C','1954-07-29', 3),
       ('D','1920-01-10', 4),
       ('E','1974-10-01', 5);

INSERT INTO categories (name) VALUES
                                  ('Fantasy'),
                                  ('Mystery'),
                                  ('Thriller'),
                                  ('Science Fiction'),
                                  ('Horror');

INSERT INTO book_category (book_id, category_id) VALUES
                                                     (1, 1),
                                                     (1, 4),
                                                     (2, 2),
                                                     (3, 1),
                                                     (3, 3),
                                                     (4, 2),
                                                     (5, 5);

