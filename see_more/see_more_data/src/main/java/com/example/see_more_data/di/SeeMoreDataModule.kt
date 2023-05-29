package com.example.see_more_data.di

import com.example.network.UnsplashApi
import com.example.see_more_data.repository.SeeMoreRepositoryImpl
import com.example.see_more_domain.repository.SeeMoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SeeMoreDataModule {

    @Provides
    @Singleton
    fun provideSeeMoreRepository(
        unsplashApi: UnsplashApi
    ): SeeMoreRepository {
        return SeeMoreRepositoryImpl(unsplashApi)
    }
}