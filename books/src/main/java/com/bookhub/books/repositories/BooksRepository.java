package com.bookhub.books.repositories;

import com.bookhub.books.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, String> {
    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByPublisherContainingIgnoreCase(String publisher);
    List<Book> findByTitle(String title);
    List<Book> findByTitleContainingIgnoreCase(String title);
}
