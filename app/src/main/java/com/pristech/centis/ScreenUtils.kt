package com.pristech.centis

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.DisplayMetrics


class DeviceInfo(context: Context) {

    private val metrics: DisplayMetrics = context.resources.displayMetrics

    fun cmToPixels(): Float {
        return metrics.ydpi / 2.54F
    }

    fun mmToPixels(): Float {
        return cmToPixels() / 10.0F
    }

    fun maxDeviceSizeInCm(): Float {
        return metrics.heightPixels / cmToPixels()
    }

}



private val textBounds: Rect = Rect() //don't new this up in a draw method


fun Canvas.drawTextCentred(text: String, cx: Float, cy: Float, paint: Paint) {
    paint.getTextBounds(text, 0, text.length, textBounds)
    drawText(text, cx - textBounds.exactCenterX(), cy - textBounds.exactCenterY(), paint)
}