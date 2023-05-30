package com.example.picview.navigation.navHost

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.picview.SplashScreen
import com.example.settings_presentation.SettingsScreen

internal const val SPLASH_ROUTE = "splash"

fun NavGraphBuilder.splashScreen(
    onNavigateToMainGraph: () -> Unit
) {
    composable(SPLASH_ROUTE) {
        SplashScreen(onNavigateToMainGraph)
    }
}