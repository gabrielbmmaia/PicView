package com.example.photo_list_presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.example.core.util.UiEvent
import com.example.core_ui.LocalSpacing
import com.example.photo_list_domain.model.UnsplashImage
import com.example.picview.ui.theme.PicViewTheme

@Composable
fun PhotoList(
    photoList: LazyPagingItems<UnsplashImage>,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val spacing = LocalSpacing.current

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(spacing.spaceMedium),
        verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = photoList,
            key = { unsplashImage ->
                unsplashImage.id
            }) { item ->
            item?.let {
                UnsplashImage(unsplashImage = it)
            }
        }
    }
}