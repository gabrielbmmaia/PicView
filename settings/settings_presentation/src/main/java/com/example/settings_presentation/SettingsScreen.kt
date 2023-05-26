package com.example.settings_presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val state = viewModel.state

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(SettingsEvent.LoadSpanCountValue)
    }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Display das Fotos"
        )
        Row {
            RadioButton(
                selected = !state.spanCount,
                onClick = {
                    viewModel.onEvent(SettingsEvent.OnSpanCountChange(false))
                }
            )
            Text(text = "Coluna")
            RadioButton(
                selected = state.spanCount,
                onClick = {
                    viewModel.onEvent(SettingsEvent.OnSpanCountChange(true))
                }
            )
            Text(text = "Grade")
        }
    }
}
