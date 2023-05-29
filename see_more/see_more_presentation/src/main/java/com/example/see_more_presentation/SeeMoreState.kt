package com.example.see_more_presentation

import androidx.paging.PagingData
import com.example.core_ui.model.PhotoUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class SeeMoreState(
    val photoList: Flow<PagingData<PhotoUiState>> = flowOf(PagingData.empty())
)
