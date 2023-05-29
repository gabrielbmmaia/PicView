package com.example.core.domain.preferences

interface Preferences {

    fun saveShouldDisplayDoubleColumn(doubleColumn: Boolean)
    fun saveAppTheme(theme: String)

    fun loadShouldDisplayDoubleColumn(): Boolean
    fun loadAppTheme(): String?

    companion object {
        const val KEY_SHOULD_DISPLAY_DOUBLE_COLUMN = "should_display_double_column"
        const val KEY_APP_THEME = "app_theme"
    }
}