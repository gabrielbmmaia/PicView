package com.example.photo_list_domain.repository

import androidx.paging.PagingData
import com.example.core.model.UnsplashImage
import kotlinx.coroutines.flow.Flow

interface UnsplashImageRepository {

    fun getAllPhotos(): Flow<PagingData<UnsplashImage>>

    fun getSearchedPhotoList(
        query: String,
        color: String
    ): Flow<PagingData<UnsplashImage>>

    fun getUserPhotosList(username: String): Flow<PagingData<UnsplashImage>>

    fun getFavoritePhotosList(): Flow<List<UnsplashImage>>

    suspend fun addFavoriteUnsplashImage(unsplashImage: UnsplashImage)

    suspend fun removeFavoriteUnsplashImage(id: String)

    suspend fun isFavoritePhoto(id: String): Boolean
}