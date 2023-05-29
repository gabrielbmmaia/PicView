package com.example.core.data

import android.content.SharedPreferences
import android.util.Log
import com.example.core.domain.preferences.Preferences

class PreferencesImpl(
    private val sharedPref: SharedPreferences
) : Preferences {
    override fun saveShouldDisplayDoubleColumn(doubleColumn: Boolean) {
        sharedPref.edit()
            .putBoolean(Preferences.KEY_SHOULD_DISPLAY_DOUBLE_COLUMN, doubleColumn)
            .apply()
    }

    override fun saveAppTheme(theme: String) {
        sharedPref.edit()
            .putString(Preferences.KEY_APP_THEME, theme)
            .apply()
    }

    override fun loadAppTheme(): String? {
        return sharedPref
            .getString(Preferences.KEY_APP_THEME, "system")
    }

    override fun loadShouldDisplayDoubleColumn(): Boolean {
        return sharedPref
            .getBoolean(Preferences.KEY_SHOULD_DISPLAY_DOUBLE_COLUMN, false)
    }
}