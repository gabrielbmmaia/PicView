package com.example.settings_presentation

sealed class AppTheme(val theme: String) {
    object LightTheme : AppTheme(
        theme = "light"
    )

    object DarkTheme : AppTheme(
        theme = "dark"
    )

    object SystemTheme : AppTheme(
        theme = "system"
    )

    fun asString(theme: String): AppTheme {
        return when (theme) {
            "light" -> LightTheme
            "dark" -> DarkTheme
            "system" -> SystemTheme
            else -> SystemTheme
        }
    }
}
