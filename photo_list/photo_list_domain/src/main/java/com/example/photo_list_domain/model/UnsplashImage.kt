package com.example.photo_list_domain.model

import java.util.Date

data class UnsplashImage(
    val id: String,
    val createdAt: String,
    val description: String?,
    val imageUrl: String?,
    val likes: Int,
    val user: User
)
