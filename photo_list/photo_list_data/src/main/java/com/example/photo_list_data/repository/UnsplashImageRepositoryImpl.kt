package com.example.photo_list_data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.core.model.UnsplashImage
import com.example.network.UnsplashApi
import com.example.network.mappers.toUnsplashImage
import com.example.photo_list_data.paging.UnsplashPagingSource
import com.example.photo_list_domain.repository.UnsplashImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class UnsplashImageRepositoryImpl @Inject constructor(
    private val unsplashApi: UnsplashApi
) : UnsplashImageRepository {

    override fun getAllPhotos(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { UnsplashPagingSource(unsplashApi = unsplashApi) }
        val pager = Pager(
            config = PagingConfig(pageSize = UnsplashApi.PER_PAGE),
            pagingSourceFactory = pagingSourceFactory
        ).flow
        return pager.map { pagingData ->
            pagingData.map { it.toUnsplashImage() }
        }
    }
}