package com.example.picview.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.picview.navigation.navHost.SPLASH_ROUTE
import com.example.picview.navigation.navHost.navigateToSeeMoreScreen
import com.example.picview.navigation.navHost.seeMoreScreen
import com.example.picview.navigation.navHost.splashScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PicViewNavHost(
    navController: NavHostController
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = SPLASH_ROUTE,
        exitTransition = { fadeOut(animationSpec = tween(300)) },
        enterTransition = { fadeIn(animationSpec = tween(300)) }
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