package com.example.photo_list_presentation.homeScreen

import androidx.paging.PagingData
import com.example.photo_list_presentation.PhotoUiState
import com.example.photo_list_presentation.seeMoreScreen.SeeMoreEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class HomeUiState(
    val photoList: Flow<PagingData<PhotoUiState>> = flowOf(PagingData.empty())
)