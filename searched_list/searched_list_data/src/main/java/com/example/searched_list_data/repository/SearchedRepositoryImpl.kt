package com.example.searched_list_data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.core.model.UnsplashImage
import com.example.network.UnsplashApi
import com.example.network.mappers.toUnsplashImage
import com.example.searched_list_data.paging.SearchedListPagingSource
import com.example.searched_list_domain.repository.SearchedRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchedRepositoryImpl @Inject constructor(
    private val unsplashApi: UnsplashApi
) : SearchedRepository {

    override fun getSearchedPhotoList(
        query: String,
        color: String
    ): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = {
            SearchedListPagingSource(
                unsplashApi,
                query.trim().lowercase(),
                color.trim().lowercase()
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