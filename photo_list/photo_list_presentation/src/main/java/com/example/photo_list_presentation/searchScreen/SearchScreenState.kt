package com.example.photo_list_presentation.searchScreen

data class SearchScreenState(
    val searchText: String = "",
    val colorSelected: String = "",
    val buttonList: List<CustomButtonUiState> = defaultCustomRadioButtonList,
)
