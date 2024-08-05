package com.bookhub.review.repositories

import com.bookhub.review.entities.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewsRepository: JpaRepository<Review, String> {
}