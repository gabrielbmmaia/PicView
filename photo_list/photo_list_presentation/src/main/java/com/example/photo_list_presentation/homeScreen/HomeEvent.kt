package com.example.photo_list_presentation.homeScreen

import com.example.photo_list_domain.model.UnsplashImage
import com.example.photo_list_presentation.PhotoUiState

sealed class HomeEvent {
//    data class OnInstagramClick(val userInstagram: String) : HomeEvent()
//    data class OnWebsiteClick(val websiteUrl: String) : HomeEvent()
//    data class OnUnsplashProfileClick(val unsplashProfile: String?) : HomeEvent()
    data class OnFavoriteClick(val unsplashImage: UnsplashImage): HomeEvent()
    object OnLoadPhotoList: HomeEvent()

}
