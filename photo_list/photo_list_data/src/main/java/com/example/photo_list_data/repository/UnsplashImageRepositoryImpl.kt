package com.example.photo_list_data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import com.example.photo_list_data.remote.UnsplashApi
import com.example.photo_list_domain.model.UnsplashImage
import com.example.photo_list_domain.repository.UnsplashImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class UnsplashImageRepositoryImpl @Inject constructor(
    private val unsplashApi: UnsplashApi
) : UnsplashImageRepository {

    override fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        TODO()
    }
}