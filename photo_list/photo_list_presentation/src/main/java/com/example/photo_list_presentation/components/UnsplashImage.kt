@file:OptIn(ExperimentalCoilApi::class)

package com.example.photo_list_presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.core_ui.LocalSpacing
import com.example.photo_list_domain.model.UnsplashImage
import core.R

@Composable
fun UnsplashImage(
    unsplashImage: UnsplashImage,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = rememberImagePainter(data = unsplashImage.imageUrl) {
                crossfade(durationMillis = 1000)
                error(R.drawable.ic_placeholder)
                placeholder(R.drawable.ic_placeholder)
            },
            contentDescription = stringResource(id = R.string.imagem_foto),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(horizontal = spacing.spaceSmall),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
            ) {
            Text(
                text = buildAnnotatedString {
                    append("Photo by ")
                    append(unsplashImage.userUsername)
                    append(" on Unsplash")
                },
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            TextCount(
                text = unsplashImage.likes.toString(),
                textColor = MaterialTheme.colorScheme.onPrimaryContainer,
                imageVector = Icons.Default.Favorite,
                imageVectorColor = MaterialTheme.colorScheme.onPrimaryContainer
            )

        }
    }
}

@Preview
@Composable
private fun UnsplashImagePreview() {
    MaterialTheme {
        UnsplashImage(
            unsplashImage = UnsplashImage(
                id = "1",
                createdAt = "",
                description = "",
                imageUrl = "",
                likes = 3,
                userUsername = "Maia",
                userUnsplashLink = ""
            )
        )
    }
}
