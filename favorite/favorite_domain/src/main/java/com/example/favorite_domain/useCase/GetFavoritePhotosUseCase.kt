package com.example.favorite_domain.useCase

import com.example.core.model.UnsplashImage
import com.example.favorite_domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoritePhotosUseCase @Inject constructor(
    private val repository: FavoriteRepository
) {
    operator fun invoke(): Flow<List<UnsplashImage>> = repository.getFavoritePhotosList()
}