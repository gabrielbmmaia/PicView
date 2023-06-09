package com.example.core.model

data class UnsplashImage(
    val id: String,
    val createdAt: String,
    val description: String?,
    val imageUrl: String?,
    val likes: Int,
    val user: User
)
