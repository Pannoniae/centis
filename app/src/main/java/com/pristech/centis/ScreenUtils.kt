package com.pristech.centis

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect

fun cmToPixels(): Int {
    return 50
}
fun mmToPixels(): Int {
    return cmToPixels() / 10
}

fun getMaxDeviceSizeInCm(): Int {
    return 50 * 15;
}

private val textBounds: Rect = Rect() //don't new this up in a draw method


fun Canvas.drawTextCentred(text: String, cx: Float, cy: Float, paint: Paint) {
    paint.getTextBounds(text, 0, text.length, textBounds)
    drawText(text, cx - textBounds.exactCenterX(), cy - textBounds.exactCenterY(), paint)
}