package com.example.photo_list_presentation.searchScreen

sealed class SearchEvent {
    data class OnQueryChange(val query: String): SearchEvent()
    data class OnButtonClicked(val button: CustomButton): SearchEvent()
    object OnSubmitClick: SearchEvent()
    object OnCloseClick: SearchEvent()
    data class OnActiveChange(val active: Boolean): SearchEvent()
    data class OnInstagramClick(val userInstagram: String) : SearchEvent()
    data class OnWebsiteClick(val websiteUrl: String) : SearchEvent()
    data class OnUnsplashProfileClick(val unsplashProfile: String?) : SearchEvent()
    data class OnSeeMoreClick(val username: String) : SearchEvent()
}
