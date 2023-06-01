package com.example.see_more_presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core_ui.Cabin
import com.example.core_ui.components.PhotoList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeeMoreScreen(
    username: String,
    onBackArrowClick: () -> Unit,
    viewModel: SeeMoreViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(SeeMoreEvent.OnLoadPhotoList(username))
    }
    val photoList = viewModel.state.photoList.collectAsLazyPagingItems()

    Column(
        Modifier.fillMaxSize(),
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = username,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = LocalTextStyle.current.copy(fontFamily = Cabin)
                )
            },
            navigationIcon = {
                IconButton(onClick = { onBackArrowClick() }) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = null
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                navigationIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
        )
        PhotoList(
            photoList = photoList,
            shouldSeeMoreShown = false,
            onFavoriteClick = { unsplashImage ->
                viewModel.onEvent(SeeMoreEvent.OnFavoriteClick(unsplashImage))
            }
        )
    }
}