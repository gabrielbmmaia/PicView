package com.example.favorite_list_data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [],
    version = 1
)
abstract class FavoriteDatabase: RoomDatabase() {
    abstract val dao: FavoriteDao
}