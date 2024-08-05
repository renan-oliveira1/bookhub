package com.bookhub.review.services

import com.bookhub.review.dto.ReviewDto
import com.bookhub.review.repositories.ReviewsRepository
import org.springframework.stereotype.Service

@Service
class ReviewsService(val reviewsRepository: ReviewsRepository): IReviewsService {

    override fun save(reviewDto: ReviewDto): ReviewDto {
        reviewsRepository.save(reviewDto)
    }

    override fun findOne(id: String): ReviewDto {
        TODO("Not yet implemented")
    }

    override fun findOneByUser(idUser: String): List<ReviewDto> {
        TODO("Not yet implemented")
    }

    override fun update(reviewDto: ReviewDto): ReviewDto {
        TODO("Not yet implemented")
    }

    override fun delete() {
        TODO("Not yet implemented")
    }
}