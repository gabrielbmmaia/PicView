package com.example.favorite_list_data.di

import android.app.Application
import androidx.room.Room
import com.example.favorite_list_data.local.FavoriteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoriteListDataModule {

    @Provides
    @Singleton
    fun provideFavoriteDatabase(app: Application): FavoriteDatabase {
        return Room.databaseBuilder(
            app,
            FavoriteDatabase::class.java,
            "favorite_db"
        ).build()
    }


}