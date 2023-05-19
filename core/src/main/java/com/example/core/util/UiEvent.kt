package com.example.core.util

sealed class UiEvent {
    object Success : UiEvent()
    object NavigateUp : UiEvent()

    data class SendIntent(val intent: UiIntent) : UiEvent()
    data class ShowSnackBar(val message: UiText) : UiEvent()
}
