package com.bookhub.review.services

import com.bookhub.review.dto.ReviewDto
import com.bookhub.review.dto.ReviewMapper
import com.bookhub.review.entities.Review
import com.bookhub.review.exception.ReviewExeption
import com.bookhub.review.repositories.ReviewsRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ReviewsService(private val reviewsRepository: ReviewsRepository): IReviewsService {

    override fun save(reviewDto: ReviewDto): ReviewDto {
        val updatedAt = LocalDate.now()
        val createAt = LocalDate.now()
        val savedReview = reviewsRepository.save(ReviewMapper.toEntity(reviewDto, updatedAt, createAt))
        return ReviewMapper.toDto(savedReview)
    }

    override fun findOne(id: String): ReviewDto {
        val reviewById = reviewsRepository.findById(id)
        if(reviewById.isEmpty){
            throw ReviewExeption("Review not found!")
        }
        return ReviewMapper.toDto(reviewById.get())
    }

    override fun findOneByUser(idUser: String): List<ReviewDto> {
        return reviewsRepository.findByUserId(idUser).map { ReviewMapper.toDto(it) }
    }

    override fun findOneByBook(idBook: String): List<ReviewDto> {
        return reviewsRepository.findByBookId(idBook).map { ReviewMapper.toDto(it) }
    }

    override fun update(reviewDto: ReviewDto): ReviewDto {
        if(reviewDto.id.isNullOrEmpty()){
            throw ReviewExeption("Id cant be empty to update the review!")
        }
        val reviewById = reviewsRepository.findById(reviewDto.id)
        if(reviewById.isEmpty){
            throw ReviewExeption("Review not found!")
        }
        val updatedDate = LocalDate.now()
        val updatedReview = reviewsRepository.save(ReviewMapper.toEntity(reviewDto, updatedDate, reviewById.get().createdAt))
        return ReviewMapper.toDto(updatedReview)
    }

    override fun delete(id: String) {
        val reviewById = reviewsRepository.findById(id)
        if(reviewById.isEmpty){
            throw ReviewExeption("Review not found!")
        }
        reviewsRepository.deleteById(id)
    }
}