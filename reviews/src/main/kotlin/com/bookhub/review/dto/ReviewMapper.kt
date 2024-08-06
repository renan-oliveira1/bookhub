package com.bookhub.review.dto

import com.bookhub.review.entities.Review
import java.time.LocalDate

class ReviewMapper {
    companion object{
        fun toDto(review: Review): ReviewDto{
            return ReviewDto(id = review.id, userId = review.userId, bookId = review.bookId, comment = review.comment, stars = review.stars,
                createdAt = review.createdAt.toString(), updatedAt = review.updatedAt.toString())
        }

        fun toEntity(reviewDto: ReviewDto, updatedAt: LocalDate, createdAt: LocalDate): Review{
            return Review(id = reviewDto.id ?: "", userId = reviewDto.userId, bookId = reviewDto.bookId, comment = reviewDto.comment, stars = reviewDto.stars,
                createdAt = createdAt, updatedAt = updatedAt)
        }
    }

}