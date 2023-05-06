package com.example.photo_list_data.mappers

import com.example.photo_list_data.local.entity.UnsplashImageEntity
import com.example.photo_list_data.remote.dtos.UnsplashImageDto

fun UnsplashImageDto.toUnsplashImageEntity(): UnsplashImageEntity {
    return UnsplashImageEntity(
        id = id,
        createdAt = createdAt,
        description = description,
        urls = urls,
        likes = likes,
        user = user
    )
}