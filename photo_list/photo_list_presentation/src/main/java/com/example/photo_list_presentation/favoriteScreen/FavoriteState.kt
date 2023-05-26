package com.example.photo_list_presentation.favoriteScreen

import androidx.paging.PagingData
import com.example.photo_list_presentation.PhotoUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class FavoriteState(
    val photoList: List<PhotoUiState> = emptyList()
)
