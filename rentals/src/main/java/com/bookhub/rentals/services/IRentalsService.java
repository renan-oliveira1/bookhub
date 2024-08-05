package com.bookhub.rentals.services;

import com.bookhub.rentals.dto.RentalDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRentalsService {
    RentalDto save(RentalDto rentalDto);
    List<RentalDto> findRentalsByUser(String idUser);
    RentalDto findRentalById(String idRental);
    List<RentalDto> findRentalsByBook(String idBook);
    List<RentalDto> findAllRentals();
    RentalDto update(RentalDto rentalDto);
    void delete(String idRental);
}
