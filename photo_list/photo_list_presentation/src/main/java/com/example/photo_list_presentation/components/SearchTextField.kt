package com.example.photo_list_presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core_ui.LocalSpacing
import com.example.core_ui.PicViewTheme
import core.R

@Composable
fun SearchTextField(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicker: () -> Unit,
    onSearchClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = { onTextChange(it) },
        placeholder = {
            Text(
                modifier = Modifier.alpha(alpha = 0.5f),
                text = stringResource(id = R.string.search),
                style = textStyle,
                color = contentColor
            )
        },
        textStyle = textStyle.copy(
            color = contentColor
        ),
        singleLine = true,
        leadingIcon = {
            IconButton(
                modifier = Modifier.alpha(0.5f),
                onClick = { onSearchClicked(text) }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.search_icon),
                    tint = contentColor
                )
            }
        },
        trailingIcon = {
            IconButton(
                modifier = Modifier.alpha(0.5f),
                onClick = {
                    if (text.isNotEmpty()) onTextChange("")
                    else onCloseClicker()
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = stringResource(id = R.string.cancel_icon),
                    tint = contentColor
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearchClicked(text)
            }
        ),
        shape = RoundedCornerShape(100),
        colors =         TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            selectionColors = TextSelectionColors(
                handleColor = Color.Transparent,
                backgroundColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        ),

    )
}

@Preview
@Composable
private fun SearchTextFieldPreview() {
    PicViewTheme {
        SearchTextField(
            text = "oi",
            onTextChange = {},
            onCloseClicker = {},
            onSearchClicked = { "" }
        )
    }
}