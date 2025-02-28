package com.itismy.interactive.pagerIndicator

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun TopPagerIndicator(
    modifier: Modifier = Modifier,
    progress: Int,
    numberOfDots: Int,
) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .padding(50.dp),
    ) {
        val dotRadius = 4.dp.toPx()
        val angleStep = 15f / numberOfDots
        val center = Offset(size.width / 2, size.height * 0.2f)
        val dialRadius = size.minDimension / 2

        repeat(numberOfDots) { index ->
            val reversedIndex = numberOfDots - 1 - index
            val angleRad = ((index - (numberOfDots / 2)) * angleStep * PI / 180) + PI
            val dotX = center.x + sin(angleRad) * (dialRadius - dotRadius)
            val dotY = center.y + cos(angleRad) * (dialRadius - dotRadius)
            val color = if (reversedIndex < progress) Color(0xFFB2FF59) else Color.Gray

            drawCircle(
                color = color,
                radius = dotRadius,
                center = Offset(dotX.toFloat(), dotY.toFloat())
            )
        }
    }
}