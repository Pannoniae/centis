package com.pristech.centis

import android.graphics.Color
import android.graphics.Paint
import kotlin.math.max

val lineThickness = 0.5F * cmToPixels()
val thickness1 = 0.1F * cmToPixels()
val thickness2 = 0.05F * cmToPixels()
// at least 1 pixel tho
val thickness3 = max(0.025F * cmToPixels(), 1F)

val fontSize = 0.5F * cmToPixels()

enum class Lines(paint: Paint) {
    LINE(Paint().apply {
        color = Color.BLACK
        strokeWidth = lineThickness
        strokeCap = Paint.Cap.ROUND
    }),
    SMALL(Paint().apply {
        color = Color.BLACK
        strokeWidth = thickness3
    }),
    MEDIUM(Paint().apply {
        color = Color.BLACK
        strokeWidth = thickness2
    }), LARGE(Paint().apply {
        color = Color.BLACK
        strokeWidth = thickness1
    }), NUMBERS(Paint().apply {
        textSize = fontSize;
    });

    val line = paint

}