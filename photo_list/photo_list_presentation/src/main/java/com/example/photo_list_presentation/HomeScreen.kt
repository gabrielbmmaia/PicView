package com.example.photo_list_presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core_ui.components.PhotoList

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
        modifier = Modifier.fillMaxSize(),
        photoList = photoList,
        onSeeMoreClick = onSeeMoreClick,
        onFavoriteClick = { unsplashImage ->
            viewModel.onEvent(HomeEvent.OnFavoriteClick(unsplashImage))
        }
    )
}