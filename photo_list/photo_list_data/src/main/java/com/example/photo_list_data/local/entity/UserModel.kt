package com.example.photo_list_data.local.entity

import androidx.room.ColumnInfo

data class UserModel(
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
