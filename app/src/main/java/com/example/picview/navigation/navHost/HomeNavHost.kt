package com.example.picview.navigation.navHost

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.example.photo_list_presentation.HomeScreen
import com.google.accompanist.navigation.animation.composable

internal const val HOME_ROUTE = "home"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeScreen(
    onNavigateToSeeMoreScreen: (username: String) -> Unit,
    screenConfiguration: Boolean
) {
    composable(HOME_ROUTE) {
        HomeScreen(
            onSeeMoreClick = onNavigateToSeeMoreScreen,
            isLandScapeConfiguration = screenConfiguration
        )
    }
}

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) =
    navigate(HOME_ROUTE, navOptions)