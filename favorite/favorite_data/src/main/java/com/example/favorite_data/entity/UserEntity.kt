package com.example.favorite_data.entity

import androidx.room.ColumnInfo

data class UserEntity(
    val name: String?,
    val username: String,
    @ColumnInfo("instagram_username")
    val instagramUsername: String?,
    @ColumnInfo("portfolio_url")
    val portfolioUrl: String?,
    @ColumnInfo("profile_image")
    val profileImage: String?,
    @ColumnInfo("profile_unsplash")
    val profileUnsplash: String?,
    val location: String?
)
