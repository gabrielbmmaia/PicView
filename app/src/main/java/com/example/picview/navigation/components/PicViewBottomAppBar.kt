package com.example.picview.navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core_ui.PicViewTheme

sealed class BottomAppBarItem(
    val label: String,
    val icon: ImageVector
) {
    object Favorite : BottomAppBarItem(
        label = "Favorito",
        icon = Icons.Rounded.Star
    )

    object Home : BottomAppBarItem(
        label = "Home",
        icon = Icons.Rounded.Home
    )

    object Search : BottomAppBarItem(
        label = "Pesquisar",
        icon = Icons.Rounded.Search
    )
}

val bottomAppBarItems = listOf(
    BottomAppBarItem.Home,
    BottomAppBarItem.Search,
    BottomAppBarItem.Favorite
)

@Composable
fun PicViewBottomAppBar(
    item: BottomAppBarItem,
    onItemChange: (BottomAppBarItem) -> Unit,
    modifier: Modifier = Modifier,
    items: List<BottomAppBarItem> = bottomAppBarItems,
) {

    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp)),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items.forEach {
            val isSelected = it.label == item.label
            val color = if (isSelected) MaterialTheme.colorScheme.onSurface
            else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)

            Column(
                Modifier
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) { onItemChange(it) }
                    .padding(PaddingValues(10.dp)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = it.icon,
                    tint = color,
                    contentDescription = it.label
                )
                Text(
                    text = it.label,
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp),
                    color = color
                )
            }
        }
    }
}

@Preview
@Composable
private fun PicViewBottomAppBarPreview() {
    PicViewTheme {
        PicViewBottomAppBar(
            BottomAppBarItem.Home,
            {}
        )
    }
}