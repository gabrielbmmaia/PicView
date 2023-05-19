package com.example.photo_list_presentation.searchScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core_ui.LocalSpacing
import com.example.photo_list_presentation.searchScreen.components.CustomRadioButton
import com.example.photo_list_presentation.searchScreen.components.SearchTextField
import core.R

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SearchScreen(
    onSearchClick: (query: String, icon: String) -> Unit,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(spacing.spaceMedium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchTextField(
            text = viewModel.state.searchText,
            onTextChange = {
                viewModel.onEvent(SearchEvent.OnQueryChange(it))
            },
            onCloseClicked = {
                viewModel.onEvent(SearchEvent.OnCloseClick)
            }
        )
        Text(
            text = stringResource(id = R.string.color_filter),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primaryContainer
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacing.spaceSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
            viewModel.state.buttonList.forEach { customButton ->
                CustomRadioButton(
                    modifier = Modifier.padding(top = spacing.spaceSmall),
                    state = customButton,
                    onButtonClicked = {
                        viewModel.onEvent(SearchEvent.OnButtonClicked(it))
                    }
                )
            }
        }
//        Button(onClick = { onSearchClick(state.searchText, state.colorSelected) }) {
//            Text(text = stringResource(id = R.string.search))
//        }
    }
}
