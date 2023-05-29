package com.example.favorite_data.repository

import com.example.core.model.UnsplashImage
import com.example.favorite_data.FavoriteDatabase
import com.example.favorite_data.toUnsplashImage
import com.example.favorite_data.toUnsplashImageEntity
import com.example.favorite_domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val favoriteDatabase: FavoriteDatabase
): FavoriteRepository {

    override fun getFavoritePhotosList(): Flow<List<UnsplashImage>> {
        return favoriteDatabase
            .dao
            .getFavoritePhotos().map { unsplashEntity ->
                unsplashEntity.map { it.toUnsplashImage() }
            }
    }

    override suspend fun addFavoriteUnsplashImage(unsplashImage: UnsplashImage) {
        favoriteDatabase.dao.addFavoriteItem(unsplashImage.toUnsplashImageEntity())
    }

    override suspend fun removeFavoriteUnsplashImage(id: String) {
        favoriteDatabase.dao.removeFavoriteItem(id)
    }

    override suspend fun isFavoritePhoto(id: String): Boolean {
        val favoriteList = favoriteDatabase.dao.isFavoriteItem(id)
        return favoriteList.isNotEmpty()
    }
}