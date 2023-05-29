package com.example.favorite_data.di

import android.content.Context
import androidx.room.Room
import com.example.favorite_data.FavoriteDatabase
import com.example.favorite_data.repository.FavoriteRepositoryImpl
import com.example.favorite_domain.repository.FavoriteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoriteDataModule {

    @Provides
    @Singleton
    fun provideFavoriteDatabase(
        @ApplicationContext context: Context
    ): FavoriteDatabase {
        return Room.databaseBuilder(
            context,
            FavoriteDatabase::class.java,
            "favorite_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideFavoriteRepository(
        favoriteDatabase: FavoriteDatabase
    ): FavoriteRepository {
        return FavoriteRepositoryImpl(favoriteDatabase)
    }
}