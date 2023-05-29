package com.example.settings_presentation

data class SettingsState(
    val spanCount: Boolean = false,
    val theme: AppTheme = AppTheme.SystemTheme
)
