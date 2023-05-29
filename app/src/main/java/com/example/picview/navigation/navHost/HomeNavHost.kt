package com.example.picview.navigation.navHost

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.photo_list_presentation.HomeScreen

internal const val HOME_ROUTE = "home"

fun NavGraphBuilder.homeScreen(
    onNavigateToSeeMoreScreen: (username: String) -> Unit
) {
    composable(HOME_ROUTE) {
        HomeScreen(
            onSeeMoreClick = onNavigateToSeeMoreScreen
        )
    }
}

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) =
    navigate(HOME_ROUTE, navOptions)