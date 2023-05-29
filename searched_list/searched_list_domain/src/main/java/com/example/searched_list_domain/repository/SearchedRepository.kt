package com.example.searched_list_domain.repository

import androidx.paging.PagingData
import com.example.core.model.UnsplashImage
import kotlinx.coroutines.flow.Flow

interface SearchedRepository {

    fun getSearchedPhotoList(
        query: String,
        color: String
    ): Flow<PagingData<UnsplashImage>>
}