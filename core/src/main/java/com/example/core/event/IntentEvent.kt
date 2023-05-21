package com.example.core.event

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import core.R

sealed class IntentEvent {
    data class OnInstagramEvent(val userInstagram: String) : IntentEvent()
    data class OnWebsiteEvent(val websiteUrl: String) : IntentEvent()
    data class OnUnsplashProfileEvent(val unsplashProfile: String) : IntentEvent()

    fun startIntent(context: Context) {
        when (this) {
            is OnInstagramEvent -> {
                val instagramUri = context.getString(R.string.instagram_username, userInstagram)
                val instagramPackage = context.getString(R.string.instagram_package)

                val webIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(instagramUri)
                )
                val appIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(instagramUri)
                ).setPackage(instagramPackage)
                try {
                    ContextCompat.startActivity(context, appIntent, null)
                } catch (e: Exception) {
                    ContextCompat.startActivity(context, webIntent, null)
                }
            }

            is OnUnsplashProfileEvent -> {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(unsplashProfile)
                )
                ContextCompat.startActivity(context, intent, null)
            }

            is OnWebsiteEvent -> {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(websiteUrl)
                )
                ContextCompat.startActivity(context, intent, null)
            }
        }
    }
}