package com.bookhub.rentals.services;

import com.bookhub.rentals.dto.RentalDto;
import com.bookhub.rentals.dto.RentalMapper;
import com.bookhub.rentals.entities.Rental;
import com.bookhub.rentals.exception.RentalException;
import com.bookhub.rentals.repositories.RentalsRepository;
import org.apache.catalina.mapper.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class RentalsService implements IRentalsService{

    private RentalsRepository rentalsRepository;

    public RentalsService(RentalsRepository rentalsRepository) {
        this.rentalsRepository = rentalsRepository;
    }

    @Override
    public RentalDto save(RentalDto rentalDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate loanDate = LocalDate.parse(rentalDto.loanDate(), formatter);
        LocalDate returnDate = LocalDate.parse(rentalDto.returnedDate(), formatter);
        LocalDate updatedDate = LocalDate.now();
        Rental savedData = RentalMapper.toEntity(rentalDto, loanDate, returnDate, updatedDate);
        return RentalMapper.toDto(savedData);
    }

    @Override
    public List<RentalDto> findRentalsByUser(String idUser) {
        return rentalsRepository.findByUserId(idUser).stream().map(RentalMapper::toDto).toList();
    }

    @Override
    public RentalDto findRentalById(String idRental) {
        Optional<Rental> optionalRental = rentalsRepository.findById(idRental);
        if(optionalRental.isEmpty()){
            throw new RentalException("Rental not found!!");
        }
        return RentalMapper.toDto(rentalsRepository.findById(idRental).get());
    }

    @Override
    public List<RentalDto> findRentalsByBook(String idBook) {
        return rentalsRepository.findByBookId(idBook).stream().map(RentalMapper::toDto).toList();
    }

    @Override
    public List<RentalDto> findAllRentals() {
        return rentalsRepository.findAll().stream().map(RentalMapper::toDto).toList();
    }

    @Override
    public RentalDto update(RentalDto rentalDto) {
        if(rentalDto.id().isEmpty()){
            throw new RentalException("Rental request with empty id!!");
        }
        Optional<Rental> optionalRental = rentalsRepository.findById(rentalDto.id());
        if(optionalRental.isEmpty()){
            throw new RentalException("Rental not found!!");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate loanDate = LocalDate.parse(rentalDto.loanDate(), formatter);
        if(!loanDate.equals(optionalRental.get().getLoanDate())){
            throw new RentalException("Can't update the loan date!");
        }
        LocalDate returnDate = LocalDate.parse(rentalDto.returnedDate(), formatter);
        LocalDate updatedDate = LocalDate.now();
        Rental updatedRental = rentalsRepository.save(RentalMapper.toEntity(rentalDto, loanDate, returnDate, updatedDate));
        return RentalMapper.toDto(updatedRental);
    }

    @Override
    public void delete(String idRental) {
        rentalsRepository.deleteById(idRental);
    }
}
