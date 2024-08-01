package com.bookhub.books.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BooksException extends RuntimeException {
    public BooksException(String message) {
        super(message);
    }
}
