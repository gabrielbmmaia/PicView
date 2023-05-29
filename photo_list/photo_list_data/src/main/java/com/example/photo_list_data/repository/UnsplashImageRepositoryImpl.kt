package com.example.photo_list_data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.core.model.UnsplashImage
import com.example.photo_list_data.local.FavoriteDatabase
import com.example.photo_list_data.mappers.toUnsplashImageEntity
import com.example.photo_list_data.paging.SearchedListPagingSource
import com.example.photo_list_data.paging.UnsplashPagingSource
import com.example.photo_list_data.paging.UserPhotoListPagingSource
import com.example.network.UnsplashApi
import com.example.network.mappers.toUnsplashImage
import com.example.photo_list_data.mappers.toUnsplashImage
import com.example.photo_list_domain.repository.UnsplashImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class UnsplashImageRepositoryImpl @Inject constructor(
    private val unsplashApi: UnsplashApi,
    private val favoriteDatabase: FavoriteDatabase
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

    override fun getUserPhotosList(
        username: String
    ): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { UserPhotoListPagingSource(unsplashApi, username) }
        val pager = Pager(
            config = PagingConfig(pageSize = UnsplashApi.PER_PAGE),
            pagingSourceFactory = pagingSourceFactory
        ).flow
        return pager.map { pagingData ->
            pagingData.map { it.toUnsplashImage() }
        }
    }

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