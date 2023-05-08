package com.example.photo_list_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UnsplashRemoteKeysEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
)
