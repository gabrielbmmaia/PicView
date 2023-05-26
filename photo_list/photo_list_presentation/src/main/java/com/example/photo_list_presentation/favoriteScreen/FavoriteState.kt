package com.example.photo_list_presentation.favoriteScreen

import com.example.photo_list_presentation.PhotoUiState

data class FavoriteState(
    val photoList: List<PhotoUiState> = emptyList()
)
