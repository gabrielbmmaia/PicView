package com.example.see_more_domain.repository

import androidx.paging.PagingData
import com.example.core.model.UnsplashImage
import kotlinx.coroutines.flow.Flow

interface SeeMoreRepository {
    fun getUserPhotosList(username: String): Flow<PagingData<UnsplashImage>>
}