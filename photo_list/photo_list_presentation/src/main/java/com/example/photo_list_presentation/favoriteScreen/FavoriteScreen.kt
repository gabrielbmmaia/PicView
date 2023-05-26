package com.example.photo_list_presentation.favoriteScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.photo_list_presentation.components.UnsplashImage

@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(FavoriteEvent.OnLoadPhotoList)
    }

    val photoStateList = viewModel.state.photoList

    LazyColumn(
        Modifier.fillMaxSize()
    ) {
        items(photoStateList) { photoState ->
            UnsplashImage(
                photoState = photoState,
                onSeeMoreClick = {},
                onFavoriteClick = {}
            )
        }
    }
}