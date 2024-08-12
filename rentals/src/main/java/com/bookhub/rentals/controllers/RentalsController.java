package com.bookhub.rentals.controllers;

import com.bookhub.rentals.dto.RentalDto;
import com.bookhub.rentals.dto.RentalsContactInfoDto;
import com.bookhub.rentals.services.IRentalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rentals")
public class RentalsController {

    private IRentalsService rentalsService;
    @Autowired
    private RentalsContactInfoDto rentalsContactInfoDto;

    public RentalsController(IRentalsService rentalsService) {
        this.rentalsService = rentalsService;
    }

    @PostMapping()
    public ResponseEntity<RentalDto> save(@RequestBody RentalDto rentalDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(rentalsService.save(rentalDto));
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<RentalDto>> findRentalsByUser(@PathVariable String idUser){
        return ResponseEntity.status(HttpStatus.OK).body(rentalsService.findRentalsByUser(idUser));
    }

    @GetMapping("/book/{idBook}")
    public ResponseEntity<List<RentalDto>> findRentalsByBook(@PathVariable String idBook){
        return ResponseEntity.status(HttpStatus.OK).body(rentalsService.findRentalsByBook(idBook));
    }

    @GetMapping()
    public ResponseEntity<List<RentalDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(rentalsService.findAllRentals());
    }

    @GetMapping("/{idRental}")
    public ResponseEntity<RentalDto> findRentalsById(@PathVariable String idRental){
        return ResponseEntity.status(HttpStatus.OK).body(rentalsService.findRentalById(idRental));
    }

    @PutMapping()
    public ResponseEntity<RentalDto> update(@RequestBody RentalDto rentalDto){
        return ResponseEntity.status(HttpStatus.OK).body(rentalsService.update(rentalDto));
    }

    @DeleteMapping("/{idRental}")
    public ResponseEntity<Object> delete(@PathVariable String idRental){
        rentalsService.delete(idRental);
        return ResponseEntity.status(HttpStatus.OK).body("Rental deleted!");
    }

    @GetMapping("/contact-info")
    public ResponseEntity<RentalsContactInfoDto> getContactInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(rentalsContactInfoDto);
    }
}
