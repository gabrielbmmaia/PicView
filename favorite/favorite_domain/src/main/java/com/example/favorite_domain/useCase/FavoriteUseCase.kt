package com.example.favorite_domain.useCase

data class FavoriteUseCase(
    val addOrRemove: AddOrRemoveFromFavoriteListUseCase,
    val isFavorite: IsFavoriteUseCase,
    val getFavoritePhotos: GetFavoritePhotosUseCase
)
