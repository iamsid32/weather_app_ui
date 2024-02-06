package com.app.weatherapplication.extension

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp

fun DrawScope.drawSunShadow(center: Offset, radius: Float) {
    val shadowColor = Color(0xFFFDE2AB)
    for (i in 1..20) {
        val alpha = (1f - (i / 20f)) * 0.1f
        val currentRadius = radius + (i * 1.dp.toPx())
        drawCircle(
            color = shadowColor.copy(alpha = alpha),
            radius = currentRadius,
            center = center
        )
    }

    drawCircle(
        color = Color(0xFFFFD600).copy(
            alpha = .01f
        ),
        radius = radius,
        center = center
    )
}