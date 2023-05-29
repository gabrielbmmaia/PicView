package com.example.photo_list_presentation.searchScreen

import com.example.core.model.UnsplashImage

sealed class SearchEvent {
    data class OnQueryChange(val query: String): SearchEvent()
    data class OnButtonClicked(val button: CustomButton): SearchEvent()
    object OnSubmitClick: SearchEvent()
    object OnCloseClick: SearchEvent()
    data class OnActiveChange(val active: Boolean): SearchEvent()
    data class OnSeeMoreClick(val username: String) : SearchEvent()
    data class OnFavoriteClick(val unsplashImage: UnsplashImage) : SearchEvent()
}
