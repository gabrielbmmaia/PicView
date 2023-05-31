package com.example.picview.navigation.components

import android.view.Window
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    BottomAppBarItem.Favorite,
    BottomAppBarItem.Home,
    BottomAppBarItem.Search
)

@Composable
fun PicViewBottomAppBar(
    item: BottomAppBarItem,
    onItemChange: (BottomAppBarItem) -> Unit,
    modifier: Modifier = Modifier,
    items: List<BottomAppBarItem> = bottomAppBarItems,
) {
    NavigationBar(
        modifier,
        containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(4.dp)
    ) {
        items.forEach {
            val icon = it.icon
            val label = it.label
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = label
                    )
                },
                label = {
                    Text(text = label)
                },
                selected = item.label == label,
                onClick = {
                    onItemChange(it)
                }
            )
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