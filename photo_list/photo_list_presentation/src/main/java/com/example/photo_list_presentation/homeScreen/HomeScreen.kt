package com.example.photo_list_presentation.homeScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core.util.UiEvent
import com.example.photo_list_presentation.components.PhotoList

@Composable
fun HomeScreen(
    onSeeMoreClick: (username: String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val photoList = viewModel.state.photoList.collectAsLazyPagingItems()

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(HomeEvent.OnLoadPhotoList)
    }

    PhotoList(
        photoList = photoList,
        onSeeMoreClick = onSeeMoreClick,
        onFavoriteClick = { unsplashImage ->
            viewModel.onEvent(HomeEvent.OnFavoriteClick(unsplashImage))
        }
    )
}