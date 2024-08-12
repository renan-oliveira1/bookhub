package com.bookhub.review

import com.bookhub.review.dto.ReviewsContactInfo
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(value = [ReviewsContactInfo::class])
class ReviewApplication

fun main(args: Array<String>) {
	runApplication<ReviewApplication>(*args)
}
