package com.example.favorite_presentation

import com.example.core_ui.model.PhotoUiState

data class FavoriteState(
    val photoList: List<PhotoUiState> = emptyList()
)
