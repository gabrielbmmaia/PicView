package com.example.favorite_presentation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core_ui.LocalSpacing
import com.example.core_ui.components.UnsplashImage

@Composable
fun FavoriteScreen(
    onSeeMoreClick: (username: String) -> Unit,
    isLandScapeConfiguration: Boolean,
    viewModel: FavoriteViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(FavoriteEvent.OnLoadPhotoList)
    }

    val spacing = LocalSpacing.current
    val photoStateList = viewModel.state.photoList

    LazyVerticalStaggeredGrid(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(spacing.spaceMedium),
        verticalItemSpacing = spacing.spaceMedium,
        horizontalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
        columns = if (isLandScapeConfiguration) StaggeredGridCells.Fixed(2)
        else StaggeredGridCells.Fixed(1)
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