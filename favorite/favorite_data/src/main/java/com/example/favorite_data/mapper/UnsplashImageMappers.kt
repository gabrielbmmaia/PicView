package com.example.favorite_data

import com.example.core.model.UnsplashImage
import com.example.core.model.User
import com.example.favorite_data.entity.UnsplashImageEntity
import com.example.favorite_data.entity.UserEntity

fun UnsplashImage.toUnsplashImageEntity(): UnsplashImageEntity {
    return UnsplashImageEntity(
        id = id,
        createdAt = createdAt,
        description = description,
        imageUrl = imageUrl,
        likes = likes,
        user = UserEntity(
            name = user.name,
            username = user.username,
            instagramUsername = user.instagramUsername,
            portfolioUrl = user.portfolioUrl,
            profileImage = user.profileImage,
            profileUnsplash = user.profileUnsplash,
            location = user.location
        )
    )
}

fun UnsplashImageEntity.toUnsplashImage(): UnsplashImage {
    return UnsplashImage(
        id = id,
        createdAt = createdAt,
        description = description,
        imageUrl = imageUrl,
        likes = likes,
        user = User(
            name = user.name,
            username = user.username,
            instagramUsername = user.instagramUsername,
            portfolioUrl = user.portfolioUrl,
            profileImage = user.profileImage,
            profileUnsplash = user.profileUnsplash,
            location = user.location
        )
    )
}