package com.example.see_more_data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.core.model.UnsplashImage
import com.example.network.UnsplashApi
import com.example.network.mappers.toUnsplashImage
import com.example.see_more_data.paging.UserPhotoListPagingSource
import com.example.see_more_domain.repository.SeeMoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SeeMoreRepositoryImpl @Inject constructor(
    private val unsplashApi: UnsplashApi
): SeeMoreRepository {

    override fun getUserPhotosList(
        username: String
    ): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = {
            UserPhotoListPagingSource(
                unsplashApi,
                username
            )
        }
        val pager = Pager(
            config = PagingConfig(pageSize = UnsplashApi.PER_PAGE),
            pagingSourceFactory = pagingSourceFactory
        ).flow
        return pager.map { pagingData ->
            pagingData.map { it.toUnsplashImage() }
        }
    }
}