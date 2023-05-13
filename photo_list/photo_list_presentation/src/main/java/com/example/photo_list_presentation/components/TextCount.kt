package com.example.photo_list_presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core_ui.LocalSpacing
import com.example.core_ui.PicViewTheme
import core.R

@Composable
fun TextCount(
    text: Int,
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
        horizontalArrangement = Arrangement.spacedBy(spacing.spaceSmall)
    ) {
        Icon(
            imageVector = imageVector,
            tint = imageVectorColor,
            modifier = Modifier.size(22.dp),
            contentDescription = stringResource(id = R.string.count_icon)
        )
        Text(
            text = text.toString(),
            color = textColor,
            style = textStyle,
            overflow = if(text < 1000) TextOverflow.Visible else TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
private fun TextCountPreview() {
    PicViewTheme {
        TextCount(
            text = 100,
            textColor = Color.White,
            imageVector = Icons.Default.Favorite,
            imageVectorColor = Color.White
        )
    }
}