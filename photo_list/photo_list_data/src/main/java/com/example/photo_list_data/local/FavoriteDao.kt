package com.example.photo_list_data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.photo_list_data.local.entity.UnsplashImageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Upsert
    suspend fun addFavoriteItem(unsplashImage: UnsplashImageEntity)

    @Query("DELETE FROM UnsplashImageEntity WHERE id = :id")
    suspend fun removeFavoriteItem(id: String)

    @Query("SELECT * FROM UnsplashImageEntity WHERE id = :id")
    suspend fun isFavoriteItem(id: String): List<UnsplashImageEntity>

    @Query("SELECT * FROM UnsplashImageEntity")
    fun getFavoritePhotos(): Flow<List<UnsplashImageEntity>>
}