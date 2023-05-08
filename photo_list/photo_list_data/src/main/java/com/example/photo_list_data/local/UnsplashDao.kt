package com.example.photo_list_data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.photo_list_data.local.entity.UnsplashImageEntity

@Dao
interface UnsplashDao {

    @Query("SELECT * FROM UnsplashImageEntity")
    fun getAllImages(): PagingSource<Int, UnsplashImageEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(images: List<UnsplashImageEntity>)

    @Query("DELETE FROM UnsplashImageEntity")
    suspend fun deleteImages()
}