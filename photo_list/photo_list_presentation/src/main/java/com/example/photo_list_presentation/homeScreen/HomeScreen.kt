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
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit ){
    viewModel.onEvent(HomeEvent.OnLoadPhotoList)
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Intent -> {
                    event.intent.startIntent(context)
                }

                else -> Unit
            }
        }
    }

    PhotoList(
        photoList = photoList,
        onWebsiteClick = { userWebsite ->
            viewModel.onEvent(HomeEvent.OnWebsiteClick(userWebsite))
        },
        onInstagramClick = { userInstagram ->
            viewModel.onEvent(HomeEvent.OnInstagramClick(userInstagram))
        },
        onProfileClick = { userUnsplashProfile ->
            viewModel.onEvent(HomeEvent.OnUnsplashProfileClick(userUnsplashProfile))
        },
        onSeeMoreClick = onSeeMoreClick,
        onFavoriteClick = {},
        onCardClick = { photoUiState ->
            viewModel.onEvent(HomeEvent.OnCardClick(photoUiState))
        }
    )
}