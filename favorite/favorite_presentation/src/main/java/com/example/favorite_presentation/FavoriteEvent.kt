package com.example.favorite_presentation

import com.example.core.model.UnsplashImage

sealed class FavoriteEvent {
    object OnLoadPhotoList : FavoriteEvent()
    data class OnFavoriteClick(val unsplashImage: UnsplashImage): FavoriteEvent()
}
