package com.example.favorite_domain.repository

import com.example.core.model.UnsplashImage
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    fun getFavoritePhotosList(): Flow<List<UnsplashImage>>

    suspend fun addFavoriteUnsplashImage(unsplashImage: UnsplashImage)

    suspend fun removeFavoriteUnsplashImage(id: String)

    suspend fun isFavoritePhoto(id: String): Boolean
}