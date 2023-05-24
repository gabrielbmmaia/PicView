package com.example.photo_list_presentation.searchScreen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core_ui.LocalSpacing
import com.example.photo_list_presentation.components.PhotoList
import com.example.photo_list_presentation.searchScreen.components.CustomRadioButton
import core.R


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SearchScreen(
    onSeeMoreClick: (username: String) -> Unit,
    viewModel: SearchViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current
    val state = viewModel.state
    val photoList = state.photoList.collectAsLazyPagingItems()

    val searchBarPadding = if (state.isBarActive) 0.dp else 8.dp

    val animationDp by animateDpAsState(targetValue = searchBarPadding)

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(animationDp),
            query = state.searchText,
            onQueryChange = {
                viewModel.onEvent(SearchEvent.OnQueryChange(it))
            },
            onSearch = {
                viewModel.onEvent(SearchEvent.OnSubmitClick)
            },
            active = state.isBarActive,
            onActiveChange = {
                viewModel.onEvent(SearchEvent.OnActiveChange(it))
            },
            placeholder = {
                Text(text = stringResource(id = R.string.search))
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = stringResource(id = R.string.search_icon)
                )
            },
            trailingIcon = {
                IconButton(onClick = {
                    if (state.searchText.isNotEmpty())
                        viewModel.onEvent(SearchEvent.OnCloseClick)
                    else
                        viewModel.onEvent(SearchEvent.OnActiveChange(false))
                }) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = stringResource(id = R.string.cancel_icon)
                    )
                }
            }
        ) {
            Text(
                text = stringResource(id = R.string.color_filter),
                modifier = Modifier.align(CenterHorizontally),
                style = MaterialTheme.typography.titleMedium
            )

            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(spacing.spaceMedium),
                horizontalArrangement = Arrangement.spacedBy(
                    spacing.spaceLarge,
                    CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                viewModel.state.buttonList.forEach { customButton ->
                    CustomRadioButton(
                        modifier = Modifier.padding(top = spacing.spaceMedium),
                        state = customButton,
                        onButtonClicked = {
                            viewModel.onEvent(SearchEvent.OnButtonClicked(it))
                        }
                    )
                }
            }
        }
        if (photoList.itemCount != 0) {
            PhotoList(
                photoList = photoList,
                onSeeMoreClick = onSeeMoreClick,
                onFavoriteClick = { unsplashImage ->
                    viewModel.onEvent(SearchEvent.OnFavoriteClick(unsplashImage))
                }
            )
        }
    }
}
