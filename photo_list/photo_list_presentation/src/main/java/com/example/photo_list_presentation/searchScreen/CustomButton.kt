package com.example.photo_list_presentation.searchScreen

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.core_ui.Blue
import com.example.core_ui.Green
import com.example.core_ui.Magenta
import com.example.core_ui.Orange
import com.example.core_ui.Purple
import com.example.core_ui.Red
import com.example.core_ui.Teal
import com.example.core_ui.Yellow
import com.example.photo_list_presentation.searchScreen.CustomButton.*
import core.R

sealed class CustomButton(
    colorName: String?,
    isEnabled: Boolean,
    size: Dp
) {
    data class SingleColorIcon(
        val color: Color,
        val colorName: String,
        val isEnabled: Boolean = false,
        val size: Dp = 24.dp
    ) : CustomButton(colorName = colorName, isEnabled = isEnabled, size = size)

    data class TwoColorIcon(
        val colorOne: Color,
        val colorTwo: Color,
        val colorName: String,
        val isEnabled: Boolean = false,
        val size: Dp = 24.dp
    ) : CustomButton(colorName = colorName, isEnabled = isEnabled, size = size)

    data class ImageVectorIcon(
        @DrawableRes
        val painterId: Int,
        val iconName: String = "",
        val isEnabled: Boolean = false,
        val size: Dp = 24.dp
    ) : CustomButton(colorName = iconName, isEnabled = isEnabled, size = size)
}

val defaultCustomRadioButtonList = listOf(
    ImageVectorIcon(
        painterId = R.drawable.ic_block
    ),
    TwoColorIcon(
        colorOne = Color.Black,
        colorTwo = Color.White,
        colorName = "black_and_white"
    ),
    SingleColorIcon(
        color = Color.Black,
        colorName = "black"
    ),
    SingleColorIcon(
        color = Color.White,
        colorName = "white"
    ),
    SingleColorIcon(
        color = Yellow,
        colorName = "yellow"
    ),
    SingleColorIcon(
        color = Orange,
        colorName = "orange"
    ),
    SingleColorIcon(
        color = Red,
        colorName = "red"
    ),
    SingleColorIcon(
        color = Purple,
        colorName = "purple"
    ),
    SingleColorIcon(
        color = Magenta,
        colorName = "magenta"
    ),
    SingleColorIcon(
        color = Green,
        colorName = "green"
    ),
    SingleColorIcon(
        color = Teal,
        colorName = "teal"
    ),
    SingleColorIcon(
        color = Blue,
        colorName = "blue"
    )
)