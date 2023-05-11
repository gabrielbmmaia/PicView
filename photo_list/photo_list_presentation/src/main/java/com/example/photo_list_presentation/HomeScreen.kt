package com.example.photo_list_presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.photo_list_presentation.components.PhotoList

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    val photoList = viewModel.photoList.collectAsLazyPagingItems()
    PhotoList(photoList = photoList)

}