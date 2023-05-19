package com.example.photo_list_presentation.searchScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(

) : ViewModel() {

    var state by mutableStateOf(SearchScreenState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: SearchEvent) {

        when (event) {
            is SearchEvent.OnButtonClicked -> {
                state = state.copy(
                    colorSelected = event.button.tag,
                    buttonList = state.buttonList.map {
                        if (it.button == event.button) {
                            it.copy(isSelected = true)
                        } else it.copy(isSelected = false)
                    }
                )
            }

            is SearchEvent.OnQueryChange -> {
                state = state.copy(searchText = event.query)
            }

            SearchEvent.OnCloseClick -> {
                state = state.copy(searchText = "")
            }

            SearchEvent.OnSubmitClick -> {}
        }
    }
}