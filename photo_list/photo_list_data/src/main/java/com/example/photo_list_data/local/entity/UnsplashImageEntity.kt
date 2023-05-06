package com.example.photo_list_data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.photo_list_data.remote.dtos.UrlsDto
import com.example.photo_list_data.remote.dtos.UserDto

@Entity
data class UnsplashImageEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val createdAt: String,
    val description: String?,
    @Embedded
    val urls: UrlsDto,
    val likes: Int,
    @Embedded
    val user: UserDto
)