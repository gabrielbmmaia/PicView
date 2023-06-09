package com.example.photo_list_domain.repository

import androidx.paging.PagingData
import com.example.core.model.UnsplashImage
import kotlinx.coroutines.flow.Flow

interface UnsplashImageRepository {
    fun getAllPhotos(): Flow<PagingData<UnsplashImage>>
}