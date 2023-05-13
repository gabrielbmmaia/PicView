package com.example.core.util

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

sealed class UiEvent {
    object Success : UiEvent()
    object NavigateUp : UiEvent()

    data class SendIntent(val intent: UiIntent) : UiEvent()
    data class ShowSnackBar(val message: UiText) : UiEvent()
}
