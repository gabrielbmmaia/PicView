package com.example.photo_list_presentation.favoriteScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.util.UiEvent
import com.example.photo_list_domain.repository.UnsplashImageRepository
import com.example.photo_list_domain.useCase.AddOrRemoveFromFavoriteListUseCase
import com.example.core_ui.model.PhotoUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repository: UnsplashImageRepository,
    private val addOrRemove: AddOrRemoveFromFavoriteListUseCase
) : ViewModel() {

    var state by mutableStateOf(FavoriteState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: FavoriteEvent) {
        when (event) {
            FavoriteEvent.OnLoadPhotoList -> {
                viewModelScope.launch {
                    repository.getFavoritePhotosList().collectLatest { imageList ->
                        state = state.copy(
                            photoList = imageList.map { image ->
                                PhotoUiState(
                                    unsplashImage = image,
                                    isFavorite = repository.isFavoritePhoto(image.id)
                                )
                            }
                        )
                    }
                }
            }

            is FavoriteEvent.OnFavoriteClick -> {
                viewModelScope.launch {
                    addOrRemove(event.unsplashImage)
                }
            }
        }
    }
}