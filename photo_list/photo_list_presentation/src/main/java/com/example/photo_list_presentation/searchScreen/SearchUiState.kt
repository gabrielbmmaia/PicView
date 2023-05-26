package com.example.photo_list_presentation.searchScreen

import androidx.paging.PagingData
import com.example.photo_list_domain.model.UnsplashImage
import com.example.photo_list_presentation.PhotoUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class SearchUiState(
    val searchText: String = "",
    val colorSelected: String = "",
    val isBarActive: Boolean = false,
    val buttonList: List<CustomButtonUiState> = defaultCustomRadioButtonList,
    val photoList: Flow<PagingData<PhotoUiState>> = flowOf(PagingData.empty())
)