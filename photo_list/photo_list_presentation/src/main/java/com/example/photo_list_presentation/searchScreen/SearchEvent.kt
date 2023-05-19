package com.example.photo_list_presentation.searchScreen

sealed class SearchEvent {
    data class OnQueryChange(val query: String): SearchEvent()
    data class OnButtonClicked(val button: CustomButton): SearchEvent()
    object OnSubmitClick: SearchEvent()
    object OnCloseClick: SearchEvent()
}
