package com.example.settings_presentation

sealed class SettingsEvent {
    data class OnSpanCountChange(val isDoubleColumn: Boolean): SettingsEvent()
    data class OnAppThemeChange(val appTheme: String): SettingsEvent()
    object LoadSpanCountValue: SettingsEvent()
    object LoadAppThemeValue: SettingsEvent()
}