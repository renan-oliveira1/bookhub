package com.bookhub.books.entities;

import jakarta.persistence.Column;
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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "books")
public class Book {
    @Id
    @UuidGenerator
    private String id;
    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private String synopsis;
    private LocalDate publication_date;
    private LocalDate created_at;
    private LocalDate updated_at;
}
