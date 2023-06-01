package com.example.core_ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.example.core.model.UnsplashImage
import com.example.core_ui.LocalSpacing
import com.example.core_ui.model.PhotoUiState
import core.R

/**
 * Lista paginada de PhotoUiState.
 * Internamente é utilizado @Composable UnsplashImage
 * para dar display nas imagens da lista.
 * */
@Composable
fun PhotoList(
    photoList: LazyPagingItems<PhotoUiState>,
    onFavoriteClick: (UnsplashImage) -> Unit,
    modifier: Modifier = Modifier,
    onSeeMoreClick: (username: String) -> Unit? = { null },
    shouldSeeMoreShown: Boolean = true,
    isLandScapeConfiguration: Boolean = false
) {

    val spacing = LocalSpacing.current
    Box(modifier = modifier.fillMaxSize()) {
        when (photoList.loadState.refresh) {
            is LoadState.NotLoading -> {
                LazyVerticalStaggeredGrid(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(spacing.spaceMedium),
                    verticalItemSpacing = spacing.spaceMedium,
                    horizontalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
                    columns = if (isLandScapeConfiguration) StaggeredGridCells.Fixed(2)
                else StaggeredGridCells.Fixed(1)
                ) {
                    items(
                        count = photoList.itemCount,
                        key = photoList.itemKey(key = { it.unsplashImage.id }
                        ),
                        contentType = photoList.itemContentType(
                        )
                    ) { index ->
                        val item = photoList[index]
                        item?.let {
                            UnsplashImage(
                                photoState = it,
                                onSeeMoreClick = onSeeMoreClick,
                                onFavoriteClick = onFavoriteClick,
                                shouldSeeMoreShown = shouldSeeMoreShown
                            )
                        }
                    }
                    when (photoList.loadState.append) {
                        LoadState.Loading -> {
                            item {
                                CircularProgressIndicator(
                                    Modifier
                                        .align(Alignment.Center)
                                        .padding(spacing.spaceSmall)
                                )
                            }
                        }

                        is LoadState.Error -> {
                            item {
                                ConnectionProblem(textButton =
                                stringResource(id = R.string.try_again),
                                    onButtonClick = { photoList.retry() })
                            }
                        }

                        else -> Unit
                    }
                }
            }

            is LoadState.Error -> {
                ConnectionProblem(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth()
                        .padding(spacing.spaceLarge),
                    textButton = stringResource(id = R.string.try_again),
                    onButtonClick = { photoList.retry() }
                )
            }

            LoadState.Loading -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }

            else -> Unit
        }
    }
}