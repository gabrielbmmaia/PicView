package com.example.searched_list_presentation

import androidx.paging.PagingData
import com.example.core_ui.model.PhotoUiState
import com.example.searched_list_presentation.model.CustomButtonUiState
import com.example.searched_list_presentation.model.firstCustomButtonList
import com.example.searched_list_presentation.model.secondCustomButtonList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class SearchUiState(
    val searchText: String = "",
    val colorSelected: String = "",
    val isBarActive: Boolean = false,
    val firstButtonList: List<CustomButtonUiState> = firstCustomButtonList,
    val secondButtonList: List<CustomButtonUiState> = secondCustomButtonList,
    val photoList: Flow<PagingData<PhotoUiState>> = flowOf(PagingData.empty())
)