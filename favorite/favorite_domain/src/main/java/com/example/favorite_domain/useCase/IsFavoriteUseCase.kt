package com.example.favorite_domain.useCase

import com.example.favorite_domain.repository.FavoriteRepository
import javax.inject.Inject

class IsFavoriteUseCase @Inject constructor(
    private val repository: FavoriteRepository
) {
    suspend operator fun invoke(id: String): Boolean = repository.isFavoritePhoto(id)
}