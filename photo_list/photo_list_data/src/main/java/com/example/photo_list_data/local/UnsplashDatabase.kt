package com.example.photo_list_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.photo_list_data.local.entity.UnsplashImageEntity
import com.example.photo_list_data.local.entity.UnsplashRemoteKeysEntity

@Database(
    entities = [UnsplashImageEntity::class, UnsplashRemoteKeysEntity::class],
    version = 1
)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao
}