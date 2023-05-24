package com.example.photo_list_domain.useCase

import com.example.photo_list_domain.model.UnsplashImage
import com.example.photo_list_domain.repository.UnsplashImageRepository
import javax.inject.Inject

class AddOrRemoveFromFavoriteListUseCase @Inject constructor(
    private val repository: UnsplashImageRepository
) {
    suspend operator fun invoke(unsplashImage: UnsplashImage) {
        if (!repository.isFavoritePhoto(unsplashImage.id))

            repository.addFavoriteUnsplashImage(unsplashImage)

        else repository.removeFavoriteUnsplashImage(unsplashImage.id)
    }
}