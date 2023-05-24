package com.example.core.util

sealed class UiEvent {
    object Navigate : UiEvent()
    object NavigateUp : UiEvent()
    data class ShowSnackBar(val message: UiText) : UiEvent()
}
