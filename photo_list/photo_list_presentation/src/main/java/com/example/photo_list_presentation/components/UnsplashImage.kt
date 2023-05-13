package com.example.photo_list_presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
    backgroundColor: Color = MaterialTheme.colorScheme.primary
) {
    val spacing = LocalSpacing.current
    val shouldDescriptionDisplay = unsplashImage.description != null
    val shouldLocationDisplay = unsplashImage.user.name != null
    val shouldWebsiteDisplay = unsplashImage.user.portfolioUrl != null
    val shouldInstagramDisplay = unsplashImage.user.instagramUsername != null

    val cornerPhotoContent = 12.dp

    var isExpanded by remember { mutableStateOf(false) }

    ElevatedCard(
        onClick = { isExpanded = !isExpanded },
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(
            topEnd = spacing.spaceSmall,
            topStart = spacing.spaceSmall,
            bottomStart = cornerPhotoContent,
            bottomEnd = cornerPhotoContent
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    painter = rememberImagePainter(data = unsplashImage.imageUrl) {
                        crossfade(durationMillis = 1000)
                        placeholder(R.drawable.ic_placeholder)
                        fallback(R.drawable.ic_placeholder)
                    },
                    contentDescription = stringResource(id = R.string.imagem_foto),
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = cornerPhotoContent,
                                topEnd = cornerPhotoContent
                            )
                        )
                        .fillMaxWidth()
                        .background(color = backgroundColor)
                        .padding(spacing.spaceSmall),
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
                        text = unsplashImage.likes,
                        textColor = textColor,
                        imageVector = Icons.Default.Favorite,
                        imageVectorColor = textColor,
                        textStyle = textStyle
                    )
                }
            }
            if (isExpanded) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(
                            start = spacing.spaceSmall,
                            end = spacing.spaceSmall,
                            bottom = spacing.spaceSmall
                        ),
                    verticalArrangement = Arrangement.spacedBy(spacing.spaceSmall)
                ) {
                    if (shouldDescriptionDisplay) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(SpanStyle(fontWeight = FontWeight.Black)) {
                                    append("Descrição: ")
                                }
                                append(unsplashImage.description!!)
                            },
                            color = textColor,
                            style = textStyle
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
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberImagePainter(
                                data = unsplashImage.user.profileImage
                            ) {
                                crossfade(500)
                                placeholder(R.drawable.basic_placeholder)
                                fallback(R.drawable.basic_placeholder)
                            }, contentDescription = stringResource(id = R.string.user_image),
                            modifier = Modifier
                                .size(35.dp)
                                .clip(RoundedCornerShape(100))
                        )
                        Spacer(modifier = Modifier.width(spacing.spaceSmall))
                        Text(
                            text = unsplashImage.user.name ?: "",
                            color = textColor,
                            style = textStyle
                        )
                        if (shouldLocationDisplay) {
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
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        if (shouldWebsiteDisplay) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_website),
                                contentDescription = stringResource(id = R.string.user_website),
                                modifier = Modifier
                                    .size(24.dp)
                                    .clickable { /*TODO*/ },
                                tint = textColor
                            )
                        }
                        if (shouldInstagramDisplay) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_instagram_bold),
                                contentDescription = stringResource(id = R.string.instagram_icon),
                                modifier = Modifier
                                    .padding(start = spacing.spaceMedium)
                                    .size(22.dp)
                                    .clickable { /*TODO*/ },
                                tint = textColor
                            )
                        }
                    }
                }
            }
        }
    }
}