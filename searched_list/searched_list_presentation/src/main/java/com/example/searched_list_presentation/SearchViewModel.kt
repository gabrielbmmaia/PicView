package com.example.searched_list_presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.core.util.UiEvent
import com.example.core_ui.model.PhotoUiState
import com.example.favorite_domain.useCase.FavoriteUseCase
import com.example.searched_list_domain.repository.SearchedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: SearchedRepository,
    private val favoriteUseCase: FavoriteUseCase
) : ViewModel() {

    var state by mutableStateOf(SearchUiState())
        private set

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.OnButtonClicked -> {
                state = state.copy(
                    firstButtonList = state.firstButtonList.map {
                        if (it.button == event.button && it.isSelected) {
                            it.copy(isSelected = false)
                        } else if (it.button == event.button) {
                            it.copy(isSelected = true)
                        } else it.copy(isSelected = false)
                    },
                    secondButtonList = state.secondButtonList.map {
                        if (it.button == event.button && it.isSelected) {
                            it.copy(isSelected = false)
                        } else if (it.button == event.button) {
                            it.copy(isSelected = true)
                        } else it.copy(isSelected = false)
                    },
                    colorSelected =
                    if (state.colorSelected == event.button.tag) ""
                    else event.button.tag
                )
            }

            is SearchEvent.OnQueryChange -> {
                state = state.copy(searchText = event.query)
            }

            SearchEvent.OnCloseClick -> {
                state = state.copy(searchText = "")
            }

            is SearchEvent.OnActiveChange -> {
                state = state.copy(isBarActive = event.active)
            }

            SearchEvent.OnSubmitClick -> {
                state = if (state.searchText.isNotEmpty()) {
                    state.copy(
                        isBarActive = false,
                        photoList = repository.getSearchedPhotoList(
                            query = state.searchText,
                            color = state.colorSelected
                        ).map { pagingData ->
                            pagingData.map { image ->
                                PhotoUiState(
                                    unsplashImage = image,
                                    isFavorite = favoriteUseCase.isFavorite(image.id)
                                )
                            }
                        }.cachedIn(viewModelScope)
                    )
                } else state.copy(isBarActive = false)
            }

            is SearchEvent.OnFavoriteClick -> {
                viewModelScope.launch {
                    favoriteUseCase.addOrRemove(event.unsplashImage)
                }
            }
        }
    }
}