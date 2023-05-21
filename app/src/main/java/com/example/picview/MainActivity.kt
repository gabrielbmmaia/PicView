package com.example.picview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.core_ui.PicViewTheme
import com.example.photo_list_presentation.searchListScreen.SearchedListScreen
import com.example.photo_list_presentation.searchScreen.SearchScreen
import com.example.picview.navigation.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PicViewTheme {
                val navController = rememberNavController()

                Box(modifier = Modifier.fillMaxSize()) {
                    NavHost(
                        navController = navController,
                        startDestination = Route.SEARCH
                    ) {
                        composable(Route.SEARCH) {
                            SearchScreen(
                                onSearchClick = { query, color ->
                                    navController.navigate(
                                        Route.SEARCH_LIST
                                                + "/$query"
                                                + "/$color"
                                    )
                                }
                            )
                        }
                        composable(
                            route = Route.SEARCH_LIST + "/{query}/{color}",
                            arguments = listOf(
                                navArgument("query") {
                                    type = NavType.StringType
                                },
                                navArgument("color") {
                                    type = NavType.StringType
                                }
                            )
                        ) { navBackStackEntry ->
                            val query = navBackStackEntry.arguments?.getString("query")!!
                            val color = navBackStackEntry.arguments?.getString("color")!!
                            SearchedListScreen(
                                query = query,
                                color = color
                            )
                        }
                    }
                }
            }
        }
    }
}