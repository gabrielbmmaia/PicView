package com.example.photo_list_presentation.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.core.event.IntentEvent
import com.example.core.util.UiEvent
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
                viewModelScope.launch {
                    _uiEvent.send(
                        UiEvent.Intent(
                            IntentEvent.OnInstagramEvent(event.userInstagram)
                        )
                    )
                }
            }

            is HomeEvent.OnUnsplashProfileClick -> {
                event.unsplashProfile?.let { url ->
                    viewModelScope.launch {
                        _uiEvent.send(
                            UiEvent.Intent(
                                IntentEvent.OnUnsplashProfileEvent(url)
                            )
                        )
                    }
                }
            }

            is HomeEvent.OnWebsiteClick -> {
                viewModelScope.launch {
                    _uiEvent.send(
                        UiEvent.Intent(
                            IntentEvent.OnWebsiteEvent(event.websiteUrl)
                        )
                    )
                }
            }
        }
    }
}