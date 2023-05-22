package com.example.photo_list_presentation.seeMoreScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.core.util.UiEvent
import com.example.photo_list_domain.repository.UnsplashImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class SeeMoreViewModel @Inject constructor(
    private val repository: UnsplashImageRepository
) : ViewModel() {

    var state by mutableStateOf(SeeMoreState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: SeeMoreEvent) {
        when (event) {
            is SeeMoreEvent.OnLoadPhotoList -> {
                state = state.copy(
                    photoList = repository.getUserPhotosList(event.username)
                        .cachedIn(viewModelScope)
                )
            }
        }
    }
}