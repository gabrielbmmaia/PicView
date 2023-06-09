package com.example.searched_list_data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.network.UnsplashApi
import com.example.network.dtos.UnsplashImageDto

/**
 * Lista de UnsplashImageDto do serviço getSearchedPhotoList de UnsplashApi
 * */
class SearchedListPagingSource(
    private val unsplashApi: UnsplashApi,
    private val query: String,
    private val color: String
) : PagingSource<Int, UnsplashImageDto>() {

    override fun getRefreshKey(state: PagingState<Int, UnsplashImageDto>): Int? =
        state.anchorPosition

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashImageDto> {
        val currentPage = params.key ?: 1
        return try {
            val response = if (color.isNotEmpty()) {
                unsplashApi.getSearchedPhotoList(
                    query = query,
                    color = color,
                    page = currentPage,
                    perPage = UnsplashApi.PER_PAGE
                ).results
            } else {
                unsplashApi.getSearchedPhotoList(
                    query = query,
                    page = currentPage,
                    perPage = UnsplashApi.PER_PAGE
                ).results
            }
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