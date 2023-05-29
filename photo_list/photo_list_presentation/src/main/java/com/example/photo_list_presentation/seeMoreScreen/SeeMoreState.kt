package com.example.photo_list_presentation.seeMoreScreen

import androidx.paging.PagingData
import com.example.core_ui.model.PhotoUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class SeeMoreState(
    val photoList: Flow<PagingData<PhotoUiState>> = flowOf(PagingData.empty())
)
