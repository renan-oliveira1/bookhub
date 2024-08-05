package com.bookhub.rentals.dto;

import com.bookhub.rentals.entities.Rental;

import java.time.LocalDate;

public class RentalMapper {

    public static Rental toEntity(RentalDto rentalDto, LocalDate loanDate, LocalDate returnDate, LocalDate updatedDate){
        return new Rental(rentalDto.id(), rentalDto.userId(), rentalDto.bookId(), loanDate, returnDate, LocalDate.now(), updatedDate);
    }

    public static RentalDto toDto(Rental entity){
        return new RentalDto(entity.getId(), entity.getUserId(), entity.getBookId(), entity.getLoanDate().toString(), entity.getReturnDate().toString(), entity.getCreatedAt().toString(), entity.getUpdatedAt().toString());
    }
}
