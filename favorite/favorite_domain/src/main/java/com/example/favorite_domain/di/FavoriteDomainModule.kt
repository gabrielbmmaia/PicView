package com.example.favorite_domain.di

import com.example.favorite_domain.repository.FavoriteRepository
import com.example.favorite_domain.useCase.AddOrRemoveFromFavoriteListUseCase
import com.example.favorite_domain.useCase.FavoriteUseCase
import com.example.favorite_domain.useCase.GetFavoritePhotosUseCase
import com.example.favorite_domain.useCase.IsFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FavoriteDomainModule {

    @Provides
    fun provideFavoriteUseCase(
        repository: FavoriteRepository
    ): FavoriteUseCase {
        return FavoriteUseCase(
            addOrRemove = AddOrRemoveFromFavoriteListUseCase(repository),
            getFavoritePhotos = GetFavoritePhotosUseCase(repository),
            isFavorite = IsFavoriteUseCase(repository)
        )
    }
}