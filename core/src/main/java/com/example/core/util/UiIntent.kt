package com.example.core.util

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat

sealed class UiIntent {
    data class Intents(val appIntent: Intent? = null, val webIntent: Intent) : UiIntent()

    fun startIntent(context: Context) {
        when (this) {
            is Intents -> {
                if (appIntent != null) {
                    try {
                        ContextCompat.startActivity(context, appIntent, null)
                    } catch (e: Exception) {
                        ContextCompat.startActivity(context, webIntent, null)
                    }
                } else {
                    ContextCompat.startActivity(context, webIntent, null)
                }
            }
        }
    }
}
