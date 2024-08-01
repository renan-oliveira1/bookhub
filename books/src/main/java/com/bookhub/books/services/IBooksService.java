package com.bookhub.books.services;

import com.bookhub.books.dto.BookDto;

import java.util.List;

public interface IBooksService {
    BookDto save(BookDto bookDto);
    List<BookDto> getAll();
    BookDto getBook(String idBook);
    List<BookDto> getBookByTitle(String title);
    List<BookDto> getBookByPublisher(String publisher);
    List<BookDto> getBookByAuthor(String author);
    BookDto update(BookDto bookDto);
    void delete(String idBook);
}
