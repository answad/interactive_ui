package com.itismy.interactive.dial

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun RotatableDial(
    modifier: Modifier = Modifier,
    progress: Int,
    setProgress: (Int) -> Unit,
) {
    var angle by remember { mutableFloatStateOf(0f) }
    var initialAngle by remember { mutableFloatStateOf(0f) }
    val numberOfDots = 13

    LaunchedEffect(progress) {
        Log.d("progress", progress.toString())
        Log.d("angle", angle.toString())
    }

    LaunchedEffect(angle) {
        val normalizedAngle = (angle % 360) % 360
        val progressValue = (normalizedAngle / 360 * numberOfDots).toInt() + 1
        setProgress(progressValue)
    }

    Box(
        modifier = modifier
            .size(150.dp)
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = { offset ->
                        val center = Offset((size.width / 2).toFloat(), (size.height / 2).toFloat())
                        initialAngle = atan2(center.y - offset.y, center.x - offset.x)
                    },
                    onDrag = { change, _ ->
                        val center = Offset((size.width / 2).toFloat(), (size.height / 2).toFloat())
                        val touchAngle =
                            atan2(center.y - change.position.y, center.x - change.position.x)
                        angle += (touchAngle - initialAngle) * (180 / PI).toFloat()
                        initialAngle = touchAngle
                    }
                )
            }
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val dotRadius = 4.dp.toPx()
            val angleStep = 360f / numberOfDots
            val center = Offset(size.width / 2, size.height / 2)
            val dialRadius = size.minDimension / 2

            repeat(numberOfDots) { index ->
                val angleRad = index * angleStep * PI / 180
                val dotX = center.x + cos(angleRad) * (dialRadius - dotRadius)
                val dotY = center.y + sin(angleRad) * (dialRadius - dotRadius)
                val color = if (index < progress) Color(0xFFB2FF59) else Color.Gray

                drawCircle(
                    color = color,
                    radius = dotRadius,
                    center = Offset(dotX.toFloat(), dotY.toFloat())
                )
            }

            drawCircle(
                color = Color.Gray,
                radius = 160f
            )

            val knobRadius = dialRadius * 0.2f
            val knobAngleRad = angle * PI / 180
            val knobX = center.x + cos(knobAngleRad) * dialRadius * 0.6f
            val knobY = center.y + sin(knobAngleRad) * dialRadius * 0.6f

            drawCircle(
                color = Color.Black,
                radius = knobRadius,
                center = Offset(knobX.toFloat(), knobY.toFloat())
            )
        }
    }
}