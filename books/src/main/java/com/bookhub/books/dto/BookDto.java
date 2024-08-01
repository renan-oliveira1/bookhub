package com.bookhub.books.dto;

import java.time.LocalDate;

public record BookDto(String id, String title, String author, String isbn, String publisher,
                      String synopsis, String publicationDate, String created_at, String  updated_at) {
}
