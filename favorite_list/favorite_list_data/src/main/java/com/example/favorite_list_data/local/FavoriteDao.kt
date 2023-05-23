package com.example.favorite_list_data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.favorite_list_data.local.model.UnsplashImageEntity

@Dao
interface FavoriteDao {

    @Upsert
    fun addFavoriteItem(unsplashImage: UnsplashImageEntity)

    @Query("DELETE FROM UnsplashImageEntity WHERE id = :id")
    fun removeFavoriteItem(id: String)

    @Query("SELECT * FROM UnsplashImageEntity WHERE id = :id")
    fun isItemFavorite(id: String): UnsplashImageEntity
}