package com.example.photo_list_presentation.favoriteScreen

import com.example.core_ui.model.PhotoUiState

data class FavoriteState(
    val photoList: List<PhotoUiState> = emptyList()
)
