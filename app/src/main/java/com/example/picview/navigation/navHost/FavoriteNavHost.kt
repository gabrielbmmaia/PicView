package com.example.picview.navigation.navHost

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.photo_list_presentation.favoriteScreen.FavoriteScreen

internal const val FAVORITE_ROUTE = "favorite"

fun NavGraphBuilder.favoriteScreen() {
    composable(FAVORITE_ROUTE) {
        FavoriteScreen(

        )
    }
}

fun NavController.navigateToFavoriteScreen(navOptions: NavOptions? = null) =
    navigate(FAVORITE_ROUTE, navOptions)