package com.bookhub.review.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDate

@Entity
@Table(name = "reviews")
data class Review(
    @Id
    @UuidGenerator
    val id: String,
    val userId: String,
    val bookId: String,
    val comment: String,
    val stars: Int,
    val createdAt: LocalDate,
    val updatedAt: LocalDate
)
