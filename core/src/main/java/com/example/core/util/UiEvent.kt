package com.example.core.util

import com.example.core.event.IntentEvent

sealed class UiEvent {
    object Success : UiEvent()
    object NavigateUp : UiEvent()
    data class Intent(val intent: IntentEvent): UiEvent()
    data class ShowSnackBar(val message: UiText) : UiEvent()
}
