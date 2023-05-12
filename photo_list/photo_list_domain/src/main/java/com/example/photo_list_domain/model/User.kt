package com.example.photo_list_domain.model

data class User(
    val name: String?,
    val username: String,
    val instagramUsername: String?,
    val portfolioUrl: String?,
    val profileImage: String?,
    val profileUnsplash: String?,
    val location: String?
)