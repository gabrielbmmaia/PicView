package com.example.photo_list_data.mappers

import com.example.photo_list_data.remote.dtos.UnsplashImageDto
import com.example.photo_list_domain.model.UnsplashImage
import com.example.photo_list_domain.model.User

fun UnsplashImageDto.toUnsplashImage(): UnsplashImage {
    return UnsplashImage(
        id = id,
        createdAt = createdAt,
        description = description,
        imageUrl = urls.regular,
        likes = likes,
        user = User(
            name = user.name,
            username = user.username,
            instagramUsername = user.instagramUsername,
            portfolioUrl = user.portfolioUrl,
            profileImage = user.profileImage.large,
            profileUnsplash = user.userLinks.html,
            location = user.location
        )
    )
}