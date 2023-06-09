package com.example.photo_list_data.di

import com.example.network.UnsplashApi
import com.example.photo_list_data.repository.UnsplashImageRepositoryImpl
import com.example.photo_list_domain.repository.UnsplashImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PhotoListDataModule {

    @Provides
    @Singleton
    fun provideUnsplashImageRepository(
        unsplashApi: UnsplashApi
    ): UnsplashImageRepository {
        return UnsplashImageRepositoryImpl(
            unsplashApi = unsplashApi
        )
    }
}