package com.example.photo_list_data.remote.dtos

import com.google.gson.annotations.SerializedName

data class UnsplashImageDto(
    val id: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("alt_description")
    val description: String?,
    val urls: UrlsDto,
    val likes: Int,
    val user: UserDto
)
