package com.example.photo_list_presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core_ui.LocalSpacing
import com.example.core_ui.PicViewTheme
import com.example.core_ui.Red10
import core.R

@Composable
fun ConnectionProblem(
    textButton: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer
) {
    val spacing = LocalSpacing.current
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(spacing.spaceSmall)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_internet_problem),
            alpha = 0.3f,
            modifier = Modifier.size(80.dp),
            contentDescription = stringResource(id = R.string.connection_problem)
        )
        TryAgainButton(
            text = textButton,
            onClick = onButtonClick,
            textStyle = textStyle,
            containerColor = containerColor,
            contentColor = contentColor
        )
    }
}

@Preview
@Composable
fun ConnectionProblemPreview() {
    PicViewTheme {
        ConnectionProblem(
            textButton = "Tente Novamente",
            onButtonClick = {}
        )
    }
}