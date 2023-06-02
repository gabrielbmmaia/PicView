package com.example.picview

import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.core_ui.Grey10
import com.example.core_ui.LocalSpacing
import com.example.core_ui.components.LockScreenOrientation

/**
 * SplashScreen com 5 possíveis telas animadas.
 * A foto é escolhida randomicamente apartir da
 * listOfImages
 * */
@Composable
fun SplashScreen(
    onArrowClick: () -> Unit
) {
    val spacing = LocalSpacing.current

    LockScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    val listOfImages = listOf(
        R.raw.background_forest,
        R.raw.background_fox,
        R.raw.background_coffee,
        R.raw.background_cat,
        R.raw.background_mountain
    )

    val randomImage = remember { listOfImages.random() }

    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(randomImage)
    )

    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        LottieAnimation(
            modifier = Modifier.fillMaxSize(),
            composition = composition,
            progress = { progress },
            contentScale = ContentScale.FillBounds,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing.spaceLarge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = core.R.string.app_name),
                fontSize = 64.sp,
                color = Grey10,
                style = TextStyle(
                    fontFamily = FontFamily(
                        Font(resId = core_ui.R.font.brawler_regular)
                    )
                )
            )

            IconButton(onClick = onArrowClick) {
                Icon(
                    tint = Grey10,
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier.size(160.dp)
                )
            }
        }
    }
}