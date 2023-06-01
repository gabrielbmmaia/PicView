package com.example.searched_list_presentation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.core_ui.LocalSpacing
import com.example.core_ui.components.PhotoList
import core.R

@OptIn(ExperimentalMaterial3Api::class)
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
        modifier = Modifier.fillMaxSize()
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
                Text(
                    text = stringResource(id = R.string.search),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Normal)
                )
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
            },

        ) {
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Text(
                text = stringResource(id = R.string.color_filter),
                modifier = Modifier.align(CenterHorizontally),
                fontSize = 26.sp,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Normal)
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        spacing.spaceLarge
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    viewModel.state.firstButtonList.forEach { customButton ->
                        CustomRadioButton(
                            modifier = Modifier.padding(top = spacing.spaceMedium),
                            state = customButton,
                            onButtonClicked = {
                                viewModel.onEvent(SearchEvent.OnButtonClicked(it))
                            }
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        spacing.spaceLarge
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    viewModel.state.secondButtonList.forEach { customButton ->
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
