package com.example.core.domain.preferences

interface Preferences {

    fun saveShouldDisplayDoubleColumn(doubleColumn: Boolean)

    fun loadShouldDisplayDoubleColumn(): Boolean

    companion object {
        const val KEY_SHOULD_DISPLAY_DOUBLE_COLUMN = "should_display_double_column"
    }
}