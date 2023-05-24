package com.example.photo_list_presentation.searchScreen

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

sealed class CustomButton(
    val tag: String,
    val size: Dp
) {
    class SingleColorIcon(
        val color: Color,
        tag: String,
        size: Dp = 32.dp
    ) : CustomButton(tag = tag, size = size)

    class TwoColorIcon(
        val colorOne: Color,
        val colorTwo: Color,
        tag: String,
        size: Dp = 32.dp
    ) : CustomButton(tag = tag, size = size)
}

val defaultCustomRadioButtonList = listOf(
    CustomButtonUiState(
        TwoColorIcon(
            colorOne = Color.Black,
            colorTwo = Color.White,
            tag = "black_and_white"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Color.Black,
            tag = "black"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Color.White,
            tag = "white"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Yellow,
            tag = "yellow"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Orange,
            tag = "orange"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Red,
            tag = "red"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Purple,
            tag = "purple"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Magenta,
            tag = "magenta"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Green,
            tag = "green"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Teal,
            tag = "teal"
        )
    ),
    CustomButtonUiState(
        SingleColorIcon(
            color = Blue,
            tag = "blue"
        )
    )
)