package com.example.photo_list_presentation.searchScreen

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
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
    val tag: String,
    val size: Dp
) {
    class SingleColorIcon(
        val color: Color,
        colorName: String,
        size: Dp = 32.dp
    ) : CustomButton(tag = colorName, size = size)

    class TwoColorIcon(
        val colorOne: Color,
        val colorTwo: Color,
        colorName: String,
        size: Dp = 32.dp
    ) : CustomButton(tag = colorName, size = size)

    class ImageVectorIcon(
        @DrawableRes
        val painterId: Int,
        iconName: String,
        size: Dp = 32.dp
    ) : CustomButton(tag = iconName, size = size)
}

val defaultCustomRadioButtonList = listOf(
    CustomButtonUiState(
        ImageVectorIcon(
            painterId = R.drawable.ic_block,
            iconName = ""
        ),
        isSelected = true
    ),
    CustomButtonUiState(
        TwoColorIcon(
            colorOne = Color.Black,
            colorTwo = Color.White,
            colorName = "black_and_white"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Color.Black,
            colorName = "black"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Color.White,
            colorName = "white"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Yellow,
            colorName = "yellow"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Orange,
            colorName = "orange"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Red,
            colorName = "red"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Purple,
            colorName = "purple"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Magenta,
            colorName = "magenta"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Green,
            colorName = "green"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Teal,
            colorName = "teal"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Blue,
            colorName = "blue"
        )
    )
)