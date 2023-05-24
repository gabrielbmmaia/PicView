package com.example.photo_list_presentation.seeMoreScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core_ui.Rubik
import com.example.photo_list_presentation.components.PhotoList

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
        Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant),
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = username,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = LocalTextStyle.current.copy(fontFamily = Rubik)
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
                containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
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