package com.example.see_more_presentation

import com.example.core.model.UnsplashImage

sealed class SeeMoreEvent {
    data class OnLoadPhotoList(val username: String): SeeMoreEvent()
    data class OnFavoriteClick(val unsplashImage: UnsplashImage): SeeMoreEvent()
}
