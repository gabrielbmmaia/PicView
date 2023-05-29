package com.example.photo_list_presentation.seeMoreScreen

import com.example.core.model.UnsplashImage

sealed class SeeMoreEvent {
    data class OnLoadPhotoList(val username: String): SeeMoreEvent()
    data class OnFavoriteClick(val unsplashImage: UnsplashImage): SeeMoreEvent()
}
