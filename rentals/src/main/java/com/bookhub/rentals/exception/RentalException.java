package com.bookhub.rentals.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RentalException extends RuntimeException{
    public RentalException(String message) {
        super(message);
    }
}
