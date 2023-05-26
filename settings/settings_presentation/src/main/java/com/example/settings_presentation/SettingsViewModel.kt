package com.example.settings_presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    var state by mutableStateOf(SettingsState())
        private set

    fun onEvent(event: SettingsEvent) {
        when (event) {
            is SettingsEvent.OnSpanCountChange -> {
                state = state.copy(
                    spanCount = event.isDoubleColumn
                )
                preferences.saveShouldDisplayDoubleColumn(event.isDoubleColumn)
            }
            SettingsEvent.LoadSpanCountValue -> {
                val spanCountValue = preferences.loadShouldDisplayDoubleColumn()
                state = state.copy(
                    spanCount = spanCountValue
                )
            }
        }
    }
}