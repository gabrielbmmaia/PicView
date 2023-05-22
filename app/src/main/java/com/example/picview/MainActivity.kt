package com.example.picview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
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
import com.example.core_ui.PicViewTheme
import com.example.picview.navigation.PicViewNavHost
import com.example.picview.navigation.components.BottomAppBarItem
import com.example.picview.navigation.components.PicViewBottomAppBar
import com.example.picview.navigation.components.bottomAppBarItems
import com.example.picview.navigation.navHost.HOME_ROUTE
import com.example.picview.navigation.navHost.SEARCH_ROUTE
import com.example.picview.navigation.navigateSingleTopWithPopUpTo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            val backStackEntryState by navController.currentBackStackEntryAsState()
            val currentDestination = backStackEntryState?.destination

            PicViewTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    val currentRoute = currentDestination?.route
                    val selectedItem by remember(currentDestination) {
                        val item = when (currentRoute) {
                            HOME_ROUTE -> BottomAppBarItem.Home
                            SEARCH_ROUTE -> BottomAppBarItem.Search
                            else -> BottomAppBarItem.Home
                        }
                        mutableStateOf(item)
                    }
                    val containsInBottomAppBarItem = when (currentRoute) {
                        HOME_ROUTE, SEARCH_ROUTE -> true
                        else -> false
                    }

                    PicViewApp(
                        onBottomAppBarItemSelectedChange = { item ->
                            navController.navigateSingleTopWithPopUpTo(item)
                        },
                        isShownBottomBar = containsInBottomAppBarItem,
                        bottomAppBarItemSelected = selectedItem
                    ) {
                        PicViewNavHost(navController = navController)
                    }
                }

//                Box(modifier = Modifier.fillMaxSize()) {
//                    NavHost(
//                        navController = navController,
//                        startDestination = Route.SEARCH
//                    ) {
//                        composable(Route.SEARCH) {
//                            SearchScreen(
//                                onSeeMoreClick = { username ->
//                                    navController.navigate(
//                                        Route.SEE_MORE + "/$username"
//                                    )
//                                }
//                            )
//                        }
//                        composable(Route.HOME) {
//                            HomeScreen({})
//                        }
//                        composable(
//                            route = Route.SEE_MORE + "/{username}",
//                            arguments = listOf(
//                                navArgument("username") {
//                                    type = NavType.StringType
//                                }
//                            )
//                        ) { backStack ->
//                            val username = backStack.arguments?.getString("username")!!
//                            SeeMoreScreen(username = username, {})
//                        }
//                    }
//                }
            }
        }
    }
}

@Composable
fun PicViewApp(
    onBottomAppBarItemSelectedChange: (BottomAppBarItem) -> Unit,
    isShownBottomBar: Boolean = false,
    bottomAppBarItemSelected: BottomAppBarItem = bottomAppBarItems[1],
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
        Box(modifier = Modifier.padding(it)) {
            content()
        }
    }
}

































