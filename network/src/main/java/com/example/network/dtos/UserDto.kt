package com.example.network.dtos

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("links")
    val userLinks: UserLinksDto,
    val username: String,
    val location: String?,
    val name: String?,
    @SerializedName("portfolio_url")
    val portfolioUrl: String?,
    @SerializedName("profile_image")
    val profileImage: UserImageDto,
    @SerializedName("instagram_username")
    val instagramUsername: String?
)
