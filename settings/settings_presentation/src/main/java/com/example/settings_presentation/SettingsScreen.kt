package com.example.settings_presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core_ui.LocalSpacing
import core.R

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val spacing = LocalSpacing.current

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(SettingsEvent.LoadSpanCountValue)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(PaddingValues(spacing.spaceLarge)),
        verticalArrangement = Arrangement.spacedBy(
            spacing.spaceExtraLarge, Alignment.CenterVertically
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.photo_apresentation),
                style = MaterialTheme.typography.titleLarge
            )
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    spacing.spaceMedium, Alignment.CenterHorizontally
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = !state.spanCount,
                        onClick = {
                            viewModel.onEvent(SettingsEvent.OnSpanCountChange(false))
                        }
                    )
                    Text(
                        text = stringResource(id = R.string.column),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = state.spanCount,
                        onClick = {
                            viewModel.onEvent(SettingsEvent.OnSpanCountChange(true))
                        }
                    )
                    Text(
                        text = stringResource(id = R.string.grid),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.app_theme),
                style = MaterialTheme.typography.titleLarge
            )
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    spacing.spaceMedium, Alignment.CenterHorizontally
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = state.theme == AppTheme.SystemTheme,
                        onClick = {
                            viewModel.onEvent(SettingsEvent.OnAppThemeChange(AppTheme.SystemTheme.theme))
                        }
                    )
                    Text(
                        text = stringResource(id = R.string.system_theme),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = state.theme == AppTheme.LightTheme,
                        onClick = {
                            viewModel.onEvent(SettingsEvent.OnAppThemeChange(AppTheme.LightTheme.theme))
                        }
                    )
                    Text(
                        text = stringResource(id = R.string.light_theme),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = state.theme == AppTheme.DarkTheme,
                        onClick = {
                            viewModel.onEvent(SettingsEvent.OnAppThemeChange(AppTheme.DarkTheme.theme))
                        }
                    )
                    Text(
                        text = stringResource(id = R.string.dark_theme),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
