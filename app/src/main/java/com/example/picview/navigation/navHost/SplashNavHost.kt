package com.example.picview.navigation.navHost

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import com.example.picview.SplashScreen
import com.google.accompanist.navigation.animation.composable

internal const val SPLASH_ROUTE = "splash"

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.splashScreen(
    onNavigateToMainGraph: () -> Unit
) {
    composable(
        route = SPLASH_ROUTE,
        exitTransition = {
            slideOutVertically(
                targetOffsetY = {-300},
                animationSpec = tween(300)
            ) + fadeOut(animationSpec = tween(300))
        }
    ) {
        SplashScreen(onNavigateToMainGraph)
    }
}