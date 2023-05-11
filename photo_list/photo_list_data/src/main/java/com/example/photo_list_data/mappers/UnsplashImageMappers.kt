package com.example.photo_list_data.mappers

import com.example.photo_list_data.remote.dtos.UnsplashImageDto
import com.example.photo_list_domain.model.UnsplashImage

fun UnsplashImageDto.toUnsplashImage(): UnsplashImage {
    return UnsplashImage(
        id = id,
        createdAt = createdAt,
        description = description,
        imageUrl = urls.regular,
        likes = likes,
        userUsername = user.username,
        userUnsplashLink = user.userLinks.html
    )
}