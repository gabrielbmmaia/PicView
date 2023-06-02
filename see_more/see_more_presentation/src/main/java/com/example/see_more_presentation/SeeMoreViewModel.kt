package com.example.see_more_presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.core_ui.model.PhotoUiState
import com.example.favorite_domain.useCase.FavoriteUseCase
import com.example.see_more_domain.repository.SeeMoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeeMoreViewModel @Inject constructor(
    private val repository: SeeMoreRepository,
    private val favoriteUseCase: FavoriteUseCase
) : ViewModel() {

    var state by mutableStateOf(SeeMoreState())
        private set

    fun onEvent(event: SeeMoreEvent) {
        when (event) {
            is SeeMoreEvent.OnLoadPhotoList -> {
                state = state.copy(
                    photoList = repository.getUserPhotosList(event.username).map { pagingData ->
                        pagingData.map { image ->
                            PhotoUiState(
                                unsplashImage = image,
                                isFavorite = favoriteUseCase.isFavorite(image.id)
                            )
                        }
                    }.cachedIn(viewModelScope)
                )
            }

            is SeeMoreEvent.OnFavoriteClick -> {
                viewModelScope.launch {
                    favoriteUseCase.addOrRemove(event.unsplashImage)
                }
            }
        }
    }
}