package com.example.photo_list_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.photo_list_data.local.entity.UnsplashImageEntity

@Database(
    entities = [UnsplashImageEntity::class],
    version = 1
)
abstract class FavoriteDatabase: RoomDatabase() {
    abstract val dao: FavoriteDao
}