package com.example.picview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.core.domain.preferences.Preferences
import com.example.core_ui.PicViewTheme
import com.example.picview.navigation.PicViewNavHost
import com.example.picview.navigation.components.BottomAppBarItem
import com.example.picview.navigation.components.PicViewBottomAppBar
import com.example.picview.navigation.navHost.FAVORITE_ROUTE
import com.example.picview.navigation.navHost.HOME_ROUTE
import com.example.picview.navigation.navHost.SEARCH_ROUTE
import com.example.picview.navigation.navHost.SETTINGS_ROUTE
import com.example.picview.navigation.navigateSingleTopWithPopUpTo
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appTheme = preferences.loadAppTheme()

        setContent {
            val navController = rememberNavController()
            val backStackEntryState by navController.currentBackStackEntryAsState()
            val currentDestination = backStackEntryState?.destination


            val isDarkTheme = when (appTheme) {
                "light" -> false
                "dark" -> true
                else -> isSystemInDarkTheme()
            }
            val shouldUseDynamicColor = when (appTheme) {
                "light", "dark" -> false
                else -> true
            }

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
                        SETTINGS_ROUTE -> BottomAppBarItem.Settings
                        else -> BottomAppBarItem.Home
                    }
                    mutableStateOf(item)
                }
                val containsInBottomAppBarItem = when (currentRoute) {
                    FAVORITE_ROUTE,
                    HOME_ROUTE,
                    SEARCH_ROUTE,
                    SETTINGS_ROUTE -> true

                    else -> false
                }

                PicViewTheme(
                    darkTheme = isDarkTheme,
                    dynamicColor = shouldUseDynamicColor
                ) {
                    PicViewApp(
                        onBottomAppBarItemSelectedChange = { item ->
                            navController.navigateSingleTopWithPopUpTo(item)
                        },
                        isShownBottomBar = containsInBottomAppBarItem,
                        bottomAppBarItemSelected = selectedItem
                    ) {
                        PicViewNavHost(
                            navController = navController
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
    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            if (isShownBottomBar) {
                PicViewBottomAppBar(
                    item = bottomAppBarItemSelected,
                    onItemChange = onBottomAppBarItemSelectedChange
                )
            }
        }
    ) {
        Surface(modifier = Modifier.padding(it)) {
            content()
        }
    }
}
