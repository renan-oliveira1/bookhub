package com.bookhub.review.controllers

import com.bookhub.review.dto.ReviewDto
import com.bookhub.review.dto.ReviewsContactInfo
import com.bookhub.review.services.IReviewsService
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Objects

@RestController
@RequestMapping(path = arrayOf("reviews"))
class ReviewController(private val reviewService: IReviewsService, private val reviewsContactInfo: ReviewsContactInfo) {

    @PostMapping()
    fun saveReview(@RequestBody reviewDto: ReviewDto): ResponseEntity<ReviewDto>{
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.save(reviewDto))
    }

    @GetMapping("/{idReview}")
    fun findOne(@PathVariable idReview: String): ResponseEntity<ReviewDto>{
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.findOne(idReview))
    }

    @GetMapping("/user/{idUser}")
    fun findByUserId(@PathVariable idUser: String): ResponseEntity<List<ReviewDto>>{
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.findOneByUser(idUser))
    }

    @GetMapping("/book/{idBook}")
    fun findByBookId(@PathVariable idBook: String): ResponseEntity<List<ReviewDto>>{
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.findOneByBook(idBook))
    }

    @PutMapping()
    fun update(@RequestBody reviewDto: ReviewDto): ResponseEntity<ReviewDto>{
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.update(reviewDto))
    }

    @DeleteMapping("{idReview}")
    fun delete(@PathVariable idReview: String): ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.OK).body("Review Deleted!!")
    }

    @GetMapping("/contact-info")
    fun getReviewContactIngo(): ResponseEntity<ReviewsContactInfo>{
        return ResponseEntity.status(HttpStatus.OK).body(reviewsContactInfo)
    }
}