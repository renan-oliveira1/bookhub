package com.bookhub.books.dto;

import com.bookhub.books.entities.Book;

import java.time.LocalDate;

public class BookMapper {
    private BookMapper() {
    }

    public static Book toEntity(BookDto bookDto, LocalDate publisherDate, LocalDate updatedDate){
        return new Book(bookDto.id(), bookDto.title(), bookDto.author(), bookDto.isbn(), bookDto.publisher(), bookDto.synopsis(),
                publisherDate, LocalDate.now(), updatedDate);
    }

    public static BookDto toDto(Book book){
        return new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getSynopsis(), book.getPublisher(),
                book.getPublication_date().toString(), book.getCreated_at().toString(), book.getUpdated_at().toString());
    }
}
