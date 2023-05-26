package com.example.photo_list_presentation.favoriteScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core_ui.LocalSpacing
import com.example.photo_list_presentation.components.UnsplashImage

@Composable
fun FavoriteScreen(
    onSeeMoreClick: (username: String) -> Unit,
    viewModel: FavoriteViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(FavoriteEvent.OnLoadPhotoList)
    }

    val spacing = LocalSpacing.current
    val photoStateList = viewModel.state.photoList

    LazyColumn(
        Modifier.fillMaxSize(),
        contentPadding = PaddingValues(spacing.spaceMedium)
    ) {
        items(photoStateList) { photoState ->
            UnsplashImage(
                photoState = photoState,
                onSeeMoreClick = onSeeMoreClick,
                onFavoriteClick = { unsplashImage ->
                    viewModel.onEvent(FavoriteEvent.OnFavoriteClick(unsplashImage))
                }
            )
        }
    }
}