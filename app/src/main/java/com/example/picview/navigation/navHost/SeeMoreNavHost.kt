package com.example.picview.navigation.navHost

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.photo_list_presentation.seeMoreScreen.SeeMoreScreen

private const val SEE_MORE_ROUTE = "see_more"
private const val USERNAME_ARGS = "username"

fun NavGraphBuilder.seeMoreScreen(
    onPopBackStack: () -> Unit
) {
    composable(
        route = "$SEE_MORE_ROUTE/{$USERNAME_ARGS}",
        arguments = listOf(
            navArgument(USERNAME_ARGS) {
                type = NavType.StringType
            }
        )
    ) { navBackStackEntry ->
        navBackStackEntry.arguments?.getString(USERNAME_ARGS)?.let { username ->
            SeeMoreScreen(
                username = username,
                onBackArrowClick = onPopBackStack
            )
        } ?: LaunchedEffect(Unit) { onPopBackStack() }
    }
}

fun NavController.navigateToSeeMoreScreen(username: String) = navigate("$SEE_MORE_ROUTE/$username")