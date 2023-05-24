package com.example.photo_list_presentation.homeScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.filter
import androidx.paging.map
import com.example.core.event.IntentEvent
import com.example.core.util.UiEvent
import com.example.photo_list_domain.repository.UnsplashImageRepository
import com.example.photo_list_presentation.PhotoUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UnsplashImageRepository
) : ViewModel() {

    val photoList = repository.getAllPhotos().cachedIn(viewModelScope)

    var state by mutableStateOf(HomeUiState())
        private set

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

            HomeEvent.OnLoadPhotoList -> {
                viewModelScope.launch {
                    state = state.copy(
                        photoList = repository.getAllPhotos().map { unsplashImages ->
                            unsplashImages.map { image ->
                                PhotoUiState(
                                    unsplashImage = image,
                                    isFavorite = repository.isFavoritePhoto(image.id)
                                )
                            }
                        }.cachedIn(viewModelScope)
                    )
                }
            }

            is HomeEvent.OnCardClick -> {
                state = state.copy(
                    photoList = state.photoList.map { pagingData ->
                        pagingData.map {
                            if (it == event.photoUiState){
                                 it.copy(isExpanded = !it.isExpanded)
                            } else it
                        }
                    }
                )
            }

            is HomeEvent.OnFavoriteClick -> {

            }
        }
    }
}