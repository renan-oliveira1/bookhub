package com.bookhub.rentals.dto;

public record RentalDto(String id, String userId, String bookId, String loanDate, String returnedDate, String createdAt, String updatedAt) {
}
