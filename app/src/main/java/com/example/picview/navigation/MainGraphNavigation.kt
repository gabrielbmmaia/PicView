package com.example.picview.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import androidx.navigation.navOptions
import com.example.picview.navigation.components.BottomAppBarItem
import com.example.picview.navigation.navHost.FAVORITE_ROUTE
import com.example.picview.navigation.navHost.HOME_ROUTE
import com.example.picview.navigation.navHost.SEARCH_ROUTE
import com.example.picview.navigation.navHost.favoriteScreen
import com.example.picview.navigation.navHost.homeScreen
import com.example.picview.navigation.navHost.navigateToFavoriteScreen
import com.example.picview.navigation.navHost.navigateToHomeScreen
import com.example.picview.navigation.navHost.navigateToSearchScreen
import com.example.picview.navigation.navHost.searchScreen

internal const val MAIN_GRAPH_ROUTE = "main_graph"

fun NavGraphBuilder.mainGraph(
    onNavigateToSeeMoreScreen: (username: String) -> Unit
) {
    navigation(
        startDestination = HOME_ROUTE,
        route = MAIN_GRAPH_ROUTE
    ) {
        favoriteScreen()
        homeScreen(onNavigateToSeeMoreScreen)
        searchScreen(onNavigateToSeeMoreScreen)
    }
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
    }

    val navOptions = navOptions {
        launchSingleTop = true
        popUpTo(route)
    }
    navigate(navOptions)
}