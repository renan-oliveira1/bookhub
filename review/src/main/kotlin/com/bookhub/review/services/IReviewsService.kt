package com.bookhub.review.services

import com.bookhub.review.dto.ReviewDto

interface IReviewsService {
    fun save(reviewDto: ReviewDto): ReviewDto
    fun findOne(id: String): ReviewDto
    fun findOneByUser(idUser: String): List<ReviewDto>
    fun update(reviewDto: ReviewDto): ReviewDto
    fun delete()
}