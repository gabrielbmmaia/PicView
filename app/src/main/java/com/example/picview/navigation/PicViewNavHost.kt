package com.example.picview.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.picview.navigation.navHost.SPLASH_ROUTE
import com.example.picview.navigation.navHost.navigateToSeeMoreScreen
import com.example.picview.navigation.navHost.seeMoreScreen
import com.example.picview.navigation.navHost.splashScreen


@Composable
fun PicViewNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = SPLASH_ROUTE
    ) {
        mainGraph(
            onNavigateToSeeMoreScreen = { username ->
                navController.navigateToSeeMoreScreen(username)
            }
        )
        seeMoreScreen(
            onPopBackStack = { navController.navigateUp() }
        )
        splashScreen(
            onNavigateToMainGraph = {navController.navigateToMainGraph()}
        )
    }
}