package com.example.picview.navigation.navHost

import android.content.res.Configuration
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import com.example.favorite_presentation.FavoriteScreen
import com.google.accompanist.navigation.animation.composable


internal const val FAVORITE_ROUTE = "favorite"

@OptIn(ExperimentalAnimationApi::class)
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