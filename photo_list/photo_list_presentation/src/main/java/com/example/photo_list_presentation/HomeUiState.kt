package com.example.photo_list_presentation

import androidx.paging.PagingData
import com.example.core_ui.model.PhotoUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class HomeUiState(
    val photoList: Flow<PagingData<PhotoUiState>> = flowOf(PagingData.empty())
)