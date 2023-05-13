package com.example.photo_list_presentation

sealed class HomeEvent {

    data class OnInstagramClick (val userInstagram :String): HomeEvent()
    data class OnWebsiteClick(val websiteUrl: String): HomeEvent()
    data class OnUnsplashProfileClick(val unsplashProfile: String?): HomeEvent()
}
