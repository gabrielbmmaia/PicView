package com.example.photo_list_data.mappers

import com.example.photo_list_data.local.entity.UnsplashImageEntity
import com.example.photo_list_data.remote.dtos.UnsplashImageDto
import com.example.photo_list_domain.model.UnsplashImage

fun UnsplashImageDto.toUnsplashImageEntity(): UnsplashImageEntity {
    return UnsplashImageEntity(
        id = id,
        createdAt = createdAt,
        description = description,
        imageUrl = urls.regular,
        likes = likes,
        userUsername = user.username,
        userUnsplashLink = user.userLinks.html
    )
}

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

fun UnsplashImageEntity.toUnsplashImage(): UnsplashImage {
    return UnsplashImage(
        id = id,
        createdAt = createdAt,
        description = description,
        imageUrl = imageUrl,
        likes = likes,
        userUsername = userUsername,
        userUnsplashLink = userUnsplashLink
    )
}