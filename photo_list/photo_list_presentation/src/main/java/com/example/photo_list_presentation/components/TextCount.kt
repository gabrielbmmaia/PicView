package com.example.photo_list_presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.core_ui.LocalSpacing
import com.example.core_ui.PicViewTheme
import core.R

@Composable
fun TextCount(
    text: String,
    textColor: Color,
    imageVector: ImageVector,
    imageVectorColor: Color,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium
) {
    val spacing = LocalSpacing.current

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Icon(
            imageVector = imageVector,
            tint = imageVectorColor,
            contentDescription = stringResource(id = R.string.count_icon)
        )
        Spacer(modifier = Modifier.width(spacing.spaceSmall))
        Text(
            text = text,
            color = textColor,
            style = textStyle
        )
    }
}

@Preview
@Composable
private fun TextCountPreview() {
    PicViewTheme {
        TextCount(
            text = "100",
            textColor = Color.White,
            imageVector = Icons.Default.Favorite,
            imageVectorColor = Color.White
        )
    }
}