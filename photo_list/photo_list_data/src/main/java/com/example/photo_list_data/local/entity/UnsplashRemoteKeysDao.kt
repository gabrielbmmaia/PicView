package com.example.photo_list_data.local.entity

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UnsplashRemoteKeysDao {

    @Query("SELECT * FROM UnsplashImageEntity WHERE id = :id")
    suspend fun getRemoteKey(id: String): UnsplashRemoteKeysEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<UnsplashRemoteKeysEntity>)

    @Query("DELETE FROM UnsplashImageEntity")
    suspend fun deleteAllRemoteKeys()
}