package com.example.photo_list_data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.network.UnsplashApi
import com.example.network.dtos.UnsplashImageDto

/**
 * Lista de UnsplashImageDto do serviço getPhotoList de UnsplashApi
 * */
class UnsplashPagingSource(
    private val unsplashApi: UnsplashApi
) : PagingSource<Int, UnsplashImageDto>() {

    override fun getRefreshKey(state: PagingState<Int, UnsplashImageDto>): Int? =
        state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashImageDto> {
        val currentPage = params.key ?: 1
        return try {
            val response = unsplashApi.getPhotoList(
                page = currentPage,
                perPage = UnsplashApi.PER_PAGE
            )
            LoadResult.Page(
                data = response,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (response.isEmpty()) null else currentPage + 1
            )
        } catch (e: Exception) {
            Log.e("UnsplashPagingSource", "${e.message}")
            LoadResult.Error(e)
        }
    }
}