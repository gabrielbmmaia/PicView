package com.example.photo_list_data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.photo_list_data.local.UnsplashDatabase
import com.example.photo_list_data.mappers.toUnsplashImage
import com.example.photo_list_data.remote.UnsplashApi
import com.example.photo_list_data.remote.UnsplashRemoteMediator
import com.example.photo_list_domain.model.UnsplashImage
import com.example.photo_list_domain.repository.UnsplashImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class UnsplashImageRepositoryImpl @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val unsplashDatabase: UnsplashDatabase
) : UnsplashImageRepository {

    override fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { unsplashDatabase.unsplashImageDao().getAllImages() }
        val pager = Pager(
            config = PagingConfig(pageSize = UnsplashApi.PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashApi = unsplashApi,
                unsplashDatabase = unsplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow

        return pager.map { entity ->
            entity.map { it.toUnsplashImage() }
        }
    }
}