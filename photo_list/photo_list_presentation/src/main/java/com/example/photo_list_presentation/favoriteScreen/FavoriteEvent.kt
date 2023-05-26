package com.example.photo_list_presentation.favoriteScreen

import com.example.photo_list_domain.model.UnsplashImage

sealed class FavoriteEvent {
    object OnLoadPhotoList : FavoriteEvent()
    data class OnFavoriteClick(val unsplashImage: UnsplashImage): FavoriteEvent()
}
