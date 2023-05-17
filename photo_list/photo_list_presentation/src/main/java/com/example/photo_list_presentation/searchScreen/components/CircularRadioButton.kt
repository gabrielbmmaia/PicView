package com.example.photo_list_presentation.searchScreen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core_ui.Magenta
import com.example.core_ui.PicViewTheme
import com.example.photo_list_presentation.searchScreen.CustomButton
import com.example.photo_list_presentation.searchScreen.CustomButton.ImageVectorIcon
import com.example.photo_list_presentation.searchScreen.CustomButton.SingleColorIcon
import com.example.photo_list_presentation.searchScreen.CustomButton.TwoColorIcon
import core.R

@Composable
fun CustomRadioButton(
    radioButton: CustomButton,
    onButtonClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    when (radioButton) {
        is SingleColorIcon -> {
            Canvas(modifier = modifier
                .clickable { onButtonClick(radioButton.colorName) }
                .size(radioButton.size)
            ) {
                drawCircle(
                    color = if (radioButton.isEnabled) radioButton.color
                    else radioButton.color.copy(alpha = 0.3f)
                )
            }
        }

        is TwoColorIcon -> {
            Canvas(modifier = modifier
                .clickable { onButtonClick(radioButton.colorName) }
                .size(radioButton.size)
            ) {
                drawArc(
                    color = if (radioButton.isEnabled) radioButton.colorOne
                    else radioButton.colorOne.copy(alpha = 0.3f),
                    startAngle = 135f,
                    sweepAngle = 180f,
                    useCenter = true,

                    )
                drawArc(
                    color = if (radioButton.isEnabled) radioButton.colorTwo
                    else radioButton.colorTwo.copy(alpha = 0.3f),
                    startAngle = 315f,
                    sweepAngle = 180f,
                    useCenter = true
                )
            }
        }

        is ImageVectorIcon -> {
            Icon(
                painter = painterResource(id = radioButton.painterId),
                contentDescription = null,
                tint = if (radioButton.isEnabled) Color.Black
                else Color.Black.copy(alpha = 0.3f),
                modifier = modifier
                    .clickable {
                        onButtonClick(radioButton.iconName)
                    }
                    .size(radioButton.size)
            )
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
                    radioButton = SingleColorIcon(
                        color = Magenta,
                        colorName = ""
                    ),
                    onButtonClick = {}
                )
                CustomRadioButton(
                    radioButton = SingleColorIcon(
                        color = Magenta,
                        colorName = "",
                        isEnabled = true
                    ),
                    onButtonClick = {}
                )
            }
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                CustomRadioButton(
                    radioButton = TwoColorIcon(
                        colorOne = Color.Black,
                        colorTwo = Color.White,
                        colorName = ""
                    ),
                    onButtonClick = {}
                )
                CustomRadioButton(
                    radioButton = TwoColorIcon(
                        colorOne = Color.Black,
                        colorTwo = Color.White,
                        isEnabled = true,
                        colorName = ""
                    ),
                    onButtonClick = {}
                )
            }
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                CustomRadioButton(
                    radioButton = ImageVectorIcon(
                        painterId = R.drawable.ic_block,
                        iconName = ""
                    ),
                    onButtonClick = {}
                )
                CustomRadioButton(
                    radioButton = ImageVectorIcon(
                        painterId = R.drawable.ic_block,
                        iconName = "",
                        isEnabled = true
                    ),
                    onButtonClick = {}
                )
            }
        }
    }
}