package com.example.photo_list_presentation

import com.example.photo_list_domain.model.UnsplashImage
import com.example.photo_list_domain.model.User

data class PhotoUiState(
    val unsplashImage: UnsplashImage = UnsplashImage(
        id = "",
        createdAt = "",
        description = null,
        imageUrl = null,
        likes = 0,
        user = User(
            name = null,
            username = "",
            instagramUsername = null,
            portfolioUrl = null,
            profileImage = null,
            profileUnsplash = null,
            location = null
        )
    ),
    val isFavorite: Boolean = false
)