package com.example.favorite_data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.favorite_data.entity.UnsplashImageEntity

@Database(
    entities = [UnsplashImageEntity::class],
    version = 1
)
abstract class FavoriteDatabase : RoomDatabase() {
    abstract val dao: FavoriteDao
}