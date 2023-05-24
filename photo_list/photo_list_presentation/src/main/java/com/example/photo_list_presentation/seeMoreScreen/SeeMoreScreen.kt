package com.example.photo_list_presentation.seeMoreScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core_ui.PicViewTheme
import com.example.photo_list_presentation.components.PhotoList

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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

    Scaffold(
        Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Teste")
                },
                navigationIcon = {
                    IconButton(onClick = { onBackArrowClick() }) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) {
        Column(
            Modifier.fillMaxWidth()
        ) {
//            PhotoList(
//                photoList = photoList,
//                onWebsiteClick = {},
//                onInstagramClick = {},
//                onProfileClick = {},
//                onSeeMoreClick = {},
//                shouldSeeMoreShown = false
//            )
        }
    }
}

@Preview
@Composable
private fun SeeMoreScreenPreview() {
    PicViewTheme {
        SeeMoreScreen("",{})
    }
}