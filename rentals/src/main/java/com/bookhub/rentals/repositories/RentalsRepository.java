package com.bookhub.rentals.repositories;

import com.bookhub.rentals.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalsRepository extends JpaRepository<Rental, String> {
    List<Rental> findByUserId(String idUser);
    List<Rental> findByBookId(String idBook);
}
