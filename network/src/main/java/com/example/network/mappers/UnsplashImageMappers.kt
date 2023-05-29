package com.example.network.mappers

import com.example.core.extensions.formatToFirstUppercase
import com.example.core.extensions.toBrazilianDate
import com.example.core.model.UnsplashImage
import com.example.core.model.User
import com.example.network.dtos.UnsplashImageDto

fun UnsplashImageDto.toUnsplashImage(): UnsplashImage {
    return UnsplashImage(
        id = id,
        createdAt = createdAt.toBrazilianDate(),
        description = description?.formatToFirstUppercase(),
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