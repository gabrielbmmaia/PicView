package com.example.picview.navigation.navHost

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.google.accompanist.navigation.animation.composable
import com.example.searched_list_presentation.SearchScreen

internal const val SEARCH_ROUTE = "search"

@OptIn(ExperimentalAnimationApi::class)
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