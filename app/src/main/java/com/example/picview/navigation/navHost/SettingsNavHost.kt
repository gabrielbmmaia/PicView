package com.example.picview.navigation.navHost

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import com.example.settings_presentation.SettingsScreen

internal const val SETTINGS_ROUTE = "settings"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.settingsScreen() {
    composable(SETTINGS_ROUTE) {
        SettingsScreen()
    }
}

fun NavController.navigateToSettingsScreen(navOptions: NavOptions? = null) =
    navigate(SETTINGS_ROUTE, navOptions)