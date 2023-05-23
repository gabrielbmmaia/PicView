package com.example.photo_list_presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.example.core_ui.LocalSpacing
import com.example.core_ui.components.NoImage
import com.example.photo_list_domain.model.UnsplashImage
import core.R

@Composable
fun PhotoList(
    photoList: LazyPagingItems<UnsplashImage>,
    onWebsiteClick: (String) -> Unit,
    onInstagramClick: (String) -> Unit,
    onProfileClick: (String?) -> Unit,
    onSeeMoreClick:(username: String) -> Unit,
    modifier: Modifier = Modifier,
    shouldSeeMoreShown: Boolean = true
) {
    val spacing = LocalSpacing.current
    Box(modifier = modifier.fillMaxSize()) {
        when (photoList.loadState.refresh) {
            is LoadState.NotLoading -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(spacing.spaceMedium),
                    verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(
                        items = photoList,
                        key = { unsplashImage ->
                            unsplashImage.id
                        }) { unsplashImage ->
                        unsplashImage?.let {
                            UnsplashImage(
                                unsplashImage = it,
                                onWebsiteClick = onWebsiteClick,
                                onInstagramClick = onInstagramClick,
                                onProfileClick = onProfileClick,
                                onSeeMoreClick = onSeeMoreClick,
                                shouldSeeMoreShown = shouldSeeMoreShown,
                                onFavoriteClick = {}
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
                if (photoList.itemCount == 0) NoImage(Modifier.align(Alignment.Center))
                else CircularProgressIndicator(Modifier.align(Alignment.Center))
            }

            else -> Unit
        }
    }
}