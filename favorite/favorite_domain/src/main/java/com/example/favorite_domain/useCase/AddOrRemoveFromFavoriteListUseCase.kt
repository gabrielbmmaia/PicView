package com.example.favorite_domain.useCase

import com.example.core.model.UnsplashImage
import com.example.favorite_domain.repository.FavoriteRepository
import javax.inject.Inject

class AddOrRemoveFromFavoriteListUseCase @Inject constructor(
    private val repository: FavoriteRepository
) {
    suspend operator fun invoke(unsplashImage: UnsplashImage) {
        if (!repository.isFavoritePhoto(unsplashImage.id))
            repository.addFavoriteUnsplashImage(unsplashImage)
        else repository.removeFavoriteUnsplashImage(unsplashImage.id)
    }
}