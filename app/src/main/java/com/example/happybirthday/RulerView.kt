package com.example.happybirthday

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class RulerView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    override fun onDraw(canvas: Canvas) {

        val x1 = 0.toFloat()
        val x2 = width.toFloat()
        val xMid = width / 2.toFloat()
        val y1 = 0.toFloat()
        val y2 = height.toFloat()
        val yMid = height / 2.toFloat()

        val xMargin = 0.25 * cmToPixels()
        val yMargin = 0.25 * cmToPixels()

        val line = Paint().apply {
            color = Color.BLACK
            strokeWidth = 5F
        }
        for (i in 0..getMaxDeviceSizeInCm()) {
            canvas.drawLine(x1, y1, x2, y1, line)
        }
    }

}