package com.bookhub.rentals.controllers;

import com.bookhub.rentals.dto.RentalDto;
import com.bookhub.rentals.services.IRentalsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rentals")
public class RentalsController {

    private IRentalsService rentalsService;

    public RentalsController(IRentalsService rentalsService) {
        this.rentalsService = rentalsService;
    }

    @PostMapping()
    public ResponseEntity<RentalDto> save(@RequestBody RentalDto rentalDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(rentalsService.save(rentalDto));
    }

    
}
