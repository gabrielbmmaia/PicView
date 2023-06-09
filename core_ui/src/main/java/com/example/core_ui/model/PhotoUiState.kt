package com.example.core_ui.model

import com.example.core.model.UnsplashImage
import com.example.core.model.User

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