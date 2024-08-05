package com.bookhub.rentals.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "rentals")
public class Rental {
    @Id
    @UuidGenerator
    private String id;
    private String userId;
    private String bookId;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
