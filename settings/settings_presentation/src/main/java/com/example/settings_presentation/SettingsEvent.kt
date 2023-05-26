package com.example.settings_presentation

sealed class SettingsEvent {
    data class OnSpanCountChange(val isDoubleColumn: Boolean): SettingsEvent()
    object LoadSpanCountValue: SettingsEvent()
}