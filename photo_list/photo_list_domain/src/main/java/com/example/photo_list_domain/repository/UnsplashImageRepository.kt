package com.example.photo_list_domain.repository

import androidx.paging.PagingData
import com.example.photo_list_domain.model.UnsplashImage
import kotlinx.coroutines.flow.Flow

interface UnsplashImageRepository {

    fun getAllImages(): Flow<PagingData<UnsplashImage>>
    fun getSearchedPhotoList(
        query: String,
        color: String
    ): Flow<PagingData<UnsplashImage>>
}