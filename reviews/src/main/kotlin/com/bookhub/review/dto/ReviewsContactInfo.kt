package com.bookhub.review.dto

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "accounts")
data class ReviewsContactInfo(
    val message: String? = null,
    val contactDetails: Map<String, String>,
     val onCallSupport: List<String>? = null
)
