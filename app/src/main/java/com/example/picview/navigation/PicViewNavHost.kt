package com.example.picview.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.picview.navigation.navHost.navigateToSeeMoreScreen
import com.example.picview.navigation.navHost.seeMoreScreen


@Composable
fun PicViewNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = MAIN_GRAPH_ROUTE
    ) {
        mainGraph(
            onNavigateToSeeMoreScreen = { username ->
                navController.navigateToSeeMoreScreen(username)
            }
        )
        seeMoreScreen(
            onPopBackStack = { navController.navigateUp() }
        )
    }
}