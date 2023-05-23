package com.example.picview.navigation.navHost

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.photo_list_presentation.searchScreen.SearchScreen

internal const val SEARCH_ROUTE = "search"

fun NavGraphBuilder.searchScreen(
    onNavigateToSeeMoreScreen: (username: String) -> Unit
) {
    composable(SEARCH_ROUTE) {
        SearchScreen(
            onSeeMoreClick = onNavigateToSeeMoreScreen
        )
    }
}

fun NavController.navigateToSearchScreen(navOptions: NavOptions? = null) =
    navigate(SEARCH_ROUTE, navOptions)