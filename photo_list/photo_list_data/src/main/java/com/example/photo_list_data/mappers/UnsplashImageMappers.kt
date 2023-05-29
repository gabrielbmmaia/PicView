package com.example.photo_list_data.mappers

import com.example.core.model.UnsplashImage
import com.example.core.model.User
import com.example.photo_list_data.local.entity.UnsplashImageEntity
import com.example.photo_list_data.local.entity.UserModel

fun UnsplashImage.toUnsplashImageEntity(): UnsplashImageEntity {
    return UnsplashImageEntity(
        id = id,
        createdAt = createdAt,
        description = description,
        imageUrl = imageUrl,
        likes = likes,
        user = UserModel(
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