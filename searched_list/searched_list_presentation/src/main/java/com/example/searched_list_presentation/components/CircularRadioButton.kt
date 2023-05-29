package com.example.searched_list_presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core_ui.Magenta
import com.example.core_ui.PicViewTheme
import com.example.searched_list_presentation.model.CustomButton
import com.example.searched_list_presentation.model.CustomButton.SingleColorIcon
import com.example.searched_list_presentation.model.CustomButton.TwoColorIcon
import com.example.searched_list_presentation.model.CustomButtonUiState

@Composable
fun CustomRadioButton(
    state: CustomButtonUiState,
    onButtonClicked: (CustomButton) -> Unit,
    modifier: Modifier = Modifier
) {
    when (state.button) {
        is SingleColorIcon -> {
            Canvas(modifier = modifier
                .clip(CircleShape)
                .size(state.button.size)
                .border(
                    width = 1.dp,
                    color = if (state.isSelected) Color.Black else Color.Black.copy(alpha = 0.3f),
                    shape = CircleShape
                )
                .clickable { onButtonClicked(state.button) }

            ) {
                drawCircle(
                    color = if (state.isSelected) state.button.color
                    else state.button.color.copy(alpha = 0.3f),
                )
            }
        }

        is TwoColorIcon -> {
            Canvas(modifier = modifier
                .clip(CircleShape)
                .size(state.button.size)
                .border(
                    width = 1.dp,
                    color = if (state.isSelected) Color.Black else Color.Black.copy(alpha = 0.3f),
                    shape = CircleShape
                )
                .clickable { onButtonClicked(state.button) }
            ) {
                drawArc(
                    color = if (state.isSelected) state.button.colorOne
                    else state.button.colorOne.copy(alpha = 0.3f),
                    startAngle = 135f,
                    sweepAngle = 180f,
                    useCenter = true,

                    )
                drawArc(
                    color = if (state.isSelected) state.button.colorTwo
                    else state.button.colorTwo.copy(alpha = 0.3f),
                    startAngle = 315f,
                    sweepAngle = 180f,
                    useCenter = true
                )
            }
        }
    }
}

@Preview(backgroundColor = 0xFF000000)
@Composable
private fun CustomRadioButtonPreview() {
    PicViewTheme {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                CustomRadioButton(
                    state = CustomButtonUiState(
                        SingleColorIcon(
                            color = Magenta,
                            tag = ""
                        )
                    ),
                    onButtonClicked = {}
                )
                CustomRadioButton(
                    state = CustomButtonUiState(
                        SingleColorIcon(
                            color = Magenta,
                            tag = ""
                        ),
                        isSelected = true
                    ),
                    onButtonClicked = {}
                )

            }
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                CustomRadioButton(
                    state = CustomButtonUiState(
                        TwoColorIcon(
                            colorOne = Color.Black,
                            colorTwo = Color.White,
                            tag = ""
                        )
                    ),
                    onButtonClicked = {}
                )
                CustomRadioButton(
                    state = CustomButtonUiState(
                        TwoColorIcon(
                            colorOne = Color.Black,
                            colorTwo = Color.White,
                            tag = ""
                        ),
                        isSelected = true
                    ),
                    onButtonClicked = {}
                )
            }
        }
    }
}