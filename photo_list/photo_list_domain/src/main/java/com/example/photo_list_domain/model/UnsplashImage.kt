package com.example.photo_list_domain.model

data class UnsplashImage(
    val id: String,
    val createdAt: String,
    val description: String?,
    val imageUrl: String?,
    val likes: Int,
    val userUsername: String,
    val userUnsplashLink: String?
)
