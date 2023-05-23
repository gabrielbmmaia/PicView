package com.example.photo_list_data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UnsplashImageEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @ColumnInfo("created_at")
    val createdAt: String,
    val description: String?,
    @ColumnInfo("image_url")
    val imageUrl: String?,
    val likes: Int,
    @Embedded
    val user: UserModel
)