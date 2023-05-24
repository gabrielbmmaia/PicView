package com.example.photo_list_domain.di

import com.example.photo_list_domain.repository.UnsplashImageRepository
import com.example.photo_list_domain.useCase.AddOrRemoveFromFavoriteListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PhotoListDomainModule {

    @Provides
    fun provideAddOrRemoveUseCase(
        repository: UnsplashImageRepository
    ): AddOrRemoveFromFavoriteListUseCase {
        return AddOrRemoveFromFavoriteListUseCase(repository)
    }
}