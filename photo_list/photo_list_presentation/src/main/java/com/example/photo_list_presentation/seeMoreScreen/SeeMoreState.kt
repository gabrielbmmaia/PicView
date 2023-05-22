package com.example.photo_list_presentation.seeMoreScreen

import androidx.paging.PagingData
import com.example.photo_list_domain.model.UnsplashImage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class SeeMoreState(
    val photoList: Flow<PagingData<UnsplashImage>> = flowOf(PagingData.empty())
)
