package com.example.picview.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.navigation
import androidx.navigation.navOptions
import com.example.picview.navigation.components.BottomAppBarItem
import com.example.picview.navigation.navHost.FAVORITE_ROUTE
import com.example.picview.navigation.navHost.HOME_ROUTE
import com.example.picview.navigation.navHost.SEARCH_ROUTE
import com.example.picview.navigation.navHost.SETTINGS_ROUTE
import com.example.picview.navigation.navHost.SPLASH_ROUTE
import com.example.picview.navigation.navHost.favoriteScreen
import com.example.picview.navigation.navHost.homeScreen
import com.example.picview.navigation.navHost.navigateToFavoriteScreen
import com.example.picview.navigation.navHost.navigateToHomeScreen
import com.example.picview.navigation.navHost.navigateToSearchScreen
import com.example.picview.navigation.navHost.navigateToSettingsScreen
import com.example.picview.navigation.navHost.searchScreen
import com.example.picview.navigation.navHost.settingsScreen

internal const val MAIN_GRAPH_ROUTE = "main_graph"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.mainGraph(
    onNavigateToSeeMoreScreen: (username: String) -> Unit
) {
    navigation(
        startDestination = HOME_ROUTE,
        route = MAIN_GRAPH_ROUTE
    ) {
        favoriteScreen(onNavigateToSeeMoreScreen)
        homeScreen(onNavigateToSeeMoreScreen)
        searchScreen(onNavigateToSeeMoreScreen)
        settingsScreen()
    }
}

fun NavController.navigateToMainGraph() {
    val navOptions = navOptions {
        popUpTo(SPLASH_ROUTE)
    }
    navigate(MAIN_GRAPH_ROUTE, navOptions)
}

fun NavController.navigateSingleTopWithPopUpTo(
    item: BottomAppBarItem
) {
    val (navigate, route) = when (item) {
        BottomAppBarItem.Favorite -> Pair(
            ::navigateToFavoriteScreen,
            FAVORITE_ROUTE
        )

        BottomAppBarItem.Home -> Pair(
            ::navigateToHomeScreen,
            HOME_ROUTE
        )

        BottomAppBarItem.Search -> Pair(
            ::navigateToSearchScreen,
            SEARCH_ROUTE
        )

        BottomAppBarItem.Settings -> Pair(
            ::navigateToSettingsScreen,
            SETTINGS_ROUTE
        )
    }

    val navOptions = navOptions {
        launchSingleTop = true
        popUpTo(route)
    }
    navigate(navOptions)
}