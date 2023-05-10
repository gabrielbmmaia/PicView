package com.example.core.util

import android.content.Context

sealed class UiText {
    data class DynamicText(val text: String) : UiText()
    data class StringResource(val resId: Int) : UiText()

    fun asString(context: Context): String {
        return when (this) {
            is DynamicText -> text
            is StringResource -> context.getString(resId)
        }
    }
}
