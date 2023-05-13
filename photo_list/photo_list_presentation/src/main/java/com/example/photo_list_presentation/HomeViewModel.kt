package com.example.photo_list_presentation

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.core.util.UiEvent
import com.example.core.util.UiIntent
import com.example.photo_list_domain.repository.UnsplashImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UnsplashImageRepository
) : ViewModel() {

    val photoList = repository.getAllImages().cachedIn(viewModelScope)

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnInstagramClick -> {
                val instagramUsername = event.userInstagram
                val instagramUrl = "https://www.instagram.com/$instagramUsername/"
                val instagramPackage = "com.instagram.android"
                viewModelScope.launch {
                    _uiEvent.send(
                        UiEvent.SendIntent(
                            UiIntent.Intents(
                                webIntent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(instagramUrl)
                                ),
                                appIntent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(instagramUrl)
                                ).setPackage(instagramPackage)
                            )
                        )
                    )
                }
            }

            is HomeEvent.OnUnsplashProfileClick -> {
                event.unsplashProfile?.let { url ->
                    viewModelScope.launch {
                        _uiEvent.send(
                            UiEvent.SendIntent(
                                UiIntent.Intents(
                                    webIntent = Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(url)
                                    )
                                )
                            )
                        )
                    }
                }
            }

            is HomeEvent.OnWebsiteClick -> {
                val url = event.websiteUrl
                viewModelScope.launch {
                    _uiEvent.send(
                        UiEvent.SendIntent(
                            UiIntent.Intents(
                                webIntent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(url)
                                )
                            )
                        )
                    )
                }
            }
        }
    }
}