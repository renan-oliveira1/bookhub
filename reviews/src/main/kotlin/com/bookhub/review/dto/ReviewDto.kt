package com.bookhub.review.dto

data class ReviewDto(val id: String?, val userId: String, val bookId: String, val comment: String,
                     val stars: Int, val createdAt: String?, val updatedAt: String?)
