package com.example.photo_list_presentation.seeMoreScreen

sealed class SeeMoreEvent {
    data class OnLoadPhotoList(val username: String): SeeMoreEvent()

}
