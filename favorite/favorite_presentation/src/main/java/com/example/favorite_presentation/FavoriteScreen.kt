package com.example.favorite_presentation
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core_ui.LocalSpacing
import com.example.core_ui.components.UnsplashImage

@Composable
fun FavoriteScreen(
    onSeeMoreClick: (username: String) -> Unit,
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(FavoriteEvent.OnLoadPhotoList)
    }

    val screenConfiguration = LocalConfiguration.current
    val spanCount = when (screenConfiguration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> StaggeredGridCells.Fixed(2)
        Configuration.ORIENTATION_PORTRAIT -> StaggeredGridCells.Fixed(1)
        else -> StaggeredGridCells.Fixed(1)
    }

    val spacing = LocalSpacing.current
    val photoStateList = viewModel.state.photoList

    LazyVerticalStaggeredGrid(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(spacing.spaceMedium),
        verticalItemSpacing = spacing.spaceMedium,
        horizontalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
        columns = spanCount
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