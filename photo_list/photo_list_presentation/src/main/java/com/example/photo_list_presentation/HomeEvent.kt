package com.example.photo_list_presentation

import com.example.core.model.UnsplashImage

sealed class HomeEvent {
    data class OnFavoriteClick(val unsplashImage: UnsplashImage): HomeEvent()
    object OnLoadPhotoList: HomeEvent()
}
