package com.example.photo_list_presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.core_ui.LocalSpacing
import com.example.core_ui.PicViewTheme
import com.example.core_ui.RubikLight
import com.example.photo_list_domain.model.UnsplashImage
import com.example.photo_list_domain.model.User
import core.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalCoilApi::class)
@Composable
fun UnsplashImage(
    unsplashImage: UnsplashImage,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall
) {
    val spacing = LocalSpacing.current

    ElevatedCard(
        onClick = { /*TODO*/ },
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        shape = CardDefaults.elevatedShape,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                painter = rememberImagePainter(data = unsplashImage.imageUrl) {
                    crossfade(durationMillis = 1000)
                    error(R.drawable.ic_placeholder)
                    placeholder(R.drawable.ic_placeholder)
                },
                contentDescription = stringResource(id = R.string.imagem_foto),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(horizontal = spacing.spaceSmall)
            ) {
                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = buildAnnotatedString {
                            append("Photo by ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(unsplashImage.user.username)
                            }
                            append(" on Unsplash")
                        },
                        color = textColor,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = textStyle
                    )
                    TextCount(
                        text = unsplashImage.likes.toString(),
                        textColor = textColor,
                        imageVector = Icons.Default.Favorite,
                        imageVectorColor = MaterialTheme.colorScheme.onPrimary,
                        textStyle = textStyle
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    if (unsplashImage.description != null) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(SpanStyle(fontWeight = FontWeight.Black)) {
                                    append("Descrição: ")
                                }
                                append(unsplashImage.description!!)
                            },
                            color = textColor,
                            textAlign = TextAlign.Justify,
                            style = textStyle,
                        )
                    }
                    Text(
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(fontWeight = FontWeight.Black)) {
                                append("Criado: ")
                            }
                            append(unsplashImage.createdAt)
                        },
                        color = textColor,
                        textAlign = TextAlign.Justify,
                        style = textStyle
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberImagePainter(
                                data = unsplashImage.user.profileImage
                            ) {
                                crossfade(500)
                                placeholder(R.drawable.basic_placeholder)
                                error(R.drawable.basic_placeholder)
                                fallback(R.drawable.basic_placeholder)
                            }, contentDescription = stringResource(id = R.string.user_image),
                            modifier = Modifier
                                .height(40.dp)
                                .width(40.dp)
                                .clip(RoundedCornerShape(100))
                        )
                        Text(
                            text = unsplashImage.user.name ?: "",
                            modifier = Modifier
                                .padding(start = spacing.spaceSmall),
                            color = textColor,
                            style = textStyle
                        )
                        if (unsplashImage.user.name != null) {
                            Text(
                                text = unsplashImage.user.location ?: "",
                                modifier = Modifier.padding(start = spacing.spaceSmall),
                                color = textColor,
                                style = textStyle.copy(fontFamily = RubikLight),
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )

                        }
                    }

                }
            }
        }
    }
}

@Preview
@Composable
private fun UnsplashImagePreview() {
    PicViewTheme {
        UnsplashImage(
            unsplashImage = UnsplashImage(
                id = "1",
                createdAt = "",
                description = LoremIpsum(20).values.first(),
                imageUrl = "",
                likes = 3,
                user = User(
                    name = "Gabriel Maia",
                    username = "gmaia",
                    instagramUsername = "gbmmaia",
                    portfolioUrl = "",
                    profileUnsplash = "",
                    profileImage = "",
                    location = "Brasil"
                )
            )
        )
    }
}
