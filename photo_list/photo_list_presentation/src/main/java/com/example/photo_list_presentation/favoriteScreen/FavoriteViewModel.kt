package com.example.photo_list_presentation.favoriteScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.photo_list_domain.repository.UnsplashImageRepository
import com.example.photo_list_presentation.PhotoUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repository: UnsplashImageRepository
) : ViewModel() {

    var state by mutableStateOf(FavoriteState())
        private set

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
        }
    }
}