package com.example.favorite_presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_ui.model.PhotoUiState
import com.example.favorite_domain.useCase.FavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favoriteUseCase: FavoriteUseCase
) : ViewModel() {

    var state by mutableStateOf(FavoriteState())
        private set

    fun onEvent(event: FavoriteEvent) {
        when (event) {
            FavoriteEvent.OnLoadPhotoList -> {
                viewModelScope.launch {
                    favoriteUseCase.getFavoritePhotos().collectLatest { imageList ->
                        state = state.copy(
                            photoList = imageList.map { image ->
                                PhotoUiState(
                                    unsplashImage = image,
                                    isFavorite = favoriteUseCase.isFavorite(image.id)
                                )
                            }
                        )
                    }
                }
            }

            is FavoriteEvent.OnFavoriteClick -> {
                viewModelScope.launch {
                    favoriteUseCase.addOrRemove(event.unsplashImage)
                }
            }
        }
    }
}