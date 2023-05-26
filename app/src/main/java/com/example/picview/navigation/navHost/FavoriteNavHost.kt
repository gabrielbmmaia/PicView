package com.example.picview.navigation.navHost

import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.photo_list_presentation.favoriteScreen.FavoriteScreen

internal const val FAVORITE_ROUTE = "favorite"

fun NavGraphBuilder.favoriteScreen(
    onNavigateToSeeMoreScreen: (username: String) -> Unit
) {
    composable(FAVORITE_ROUTE) {
        FavoriteScreen(
            onSeeMoreClick = onNavigateToSeeMoreScreen
        )
    }
}

fun NavController.navigateToFavoriteScreen(navOptions: NavOptions? = null) =
    navigate(FAVORITE_ROUTE, navOptions)