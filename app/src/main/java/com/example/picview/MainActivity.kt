package com.example.picview

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.core_ui.PicViewTheme
import com.example.picview.navigation.PicViewNavHost
import com.example.picview.navigation.components.BottomAppBarItem
import com.example.picview.navigation.components.PicViewBottomAppBar
import com.example.picview.navigation.navHost.FAVORITE_ROUTE
import com.example.picview.navigation.navHost.HOME_ROUTE
import com.example.picview.navigation.navHost.SEARCH_ROUTE
import com.example.picview.navigation.navigateSingleTopWithPopUpTo
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalAnimationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PicViewTheme {

                val navController = rememberAnimatedNavController()
                val backStackEntryState by navController.currentBackStackEntryAsState()
                val currentDestination = backStackEntryState?.destination

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    val currentRoute = currentDestination?.route
                    val selectedItem by remember(currentDestination) {
                        val item = when (currentRoute) {
                            FAVORITE_ROUTE -> BottomAppBarItem.Favorite
                            HOME_ROUTE -> BottomAppBarItem.Home
                            SEARCH_ROUTE -> BottomAppBarItem.Search
                            else -> BottomAppBarItem.Home
                        }
                        mutableStateOf(item)
                    }
                    val containsInBottomAppBarItem = when (currentRoute) {
                        FAVORITE_ROUTE,
                        HOME_ROUTE,
                        SEARCH_ROUTE -> true

                        else -> false
                    }

                    PicViewApp(
                        onBottomAppBarItemSelectedChange = { item ->
                            navController.navigateSingleTopWithPopUpTo(item)
                        },
                        isShownBottomBar = containsInBottomAppBarItem,
                        bottomAppBarItemSelected = selectedItem
                    ) { isLandScapeConfiguration ->
                        PicViewNavHost(
                            navController = navController,
                            screenConfiguration = isLandScapeConfiguration
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PicViewApp(
    onBottomAppBarItemSelectedChange: (BottomAppBarItem) -> Unit,
    isShownBottomBar: Boolean = false,
    bottomAppBarItemSelected: BottomAppBarItem,
    content: @Composable (isLandScapeConfiguration: Boolean) -> Unit
) {
    Scaffold(
        bottomBar = {
            if (isShownBottomBar) {
                PicViewBottomAppBar(
                    item = bottomAppBarItemSelected,
                    onItemChange = onBottomAppBarItemSelectedChange
                )
                Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.navigationBars))
            }
        }
    ) {
        val configuration = LocalConfiguration.current
        val screenConfiguration = when (configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> false
            Configuration.ORIENTATION_LANDSCAPE -> true
            else -> false
        }
        Surface(
            modifier = Modifier.padding(it)
        ) {
            content(screenConfiguration)
        }
    }
}
