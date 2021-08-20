package com.pristech.centis

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class RulerView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    override fun onDraw(canvas: Canvas) {

        val xMargin = 0.25F * cmToPixels()
        val yMargin = 0.25F * cmToPixels()

        val x1 = 0.toFloat() + xMargin
        val x2 = width.toFloat() - yMargin
        //val xMid = width / 2.toFloat()
        //val y1 = 0.toFloat() + yMargin
        val y2 = height.toFloat()  - yMargin
        //val yMid = height / 2.toFloat()

        val lineThickness = 0.5F * cmToPixels()
        val thickness1 = 0.1F * cmToPixels()
        val thickness2 = 0.05F * cmToPixels()
        val thickness3 = 0.01F * cmToPixels()

        //val fontSize = 0.5F * cmToPixels()

        val smallLineHeight = 1F * cmToPixels()
        val midLineHeight = 1.25F * cmToPixels()
        val largeLineHeight = 1.5F * cmToPixels()

        val line = Paint().apply {
            color = Color.BLACK
            strokeWidth = lineThickness
            strokeCap = Paint.Cap.ROUND
        }

        val largeLine = Paint().apply {
            color = Color.BLACK
            strokeWidth = thickness1
        }
        val midLine = Paint().apply {
            color = Color.BLACK
            strokeWidth = thickness2
        }
        val smallLine = Paint().apply {
            color = Color.BLACK
            strokeWidth = thickness3
        }

        val numbers = Paint().apply {
            textSize = (0.5 * cmToPixels()).toFloat()
        }
        // bottom line
        canvas.drawLine(x1, y2, x2, y2, line)
        // numbers
        for (i in 0..getMaxDeviceSizeInCm()) {
            canvas.drawTextCentred(
                i.toString(), (i * cmToPixels()).toFloat() + x1,
                y2 - largeLineHeight - yMargin, numbers
            )
        }
        // the lines
        for (i in (0..getMaxDeviceSizeInCm() * 10)) {
            // i is in mm, j is in cm
            //val j = i / 10;
            var theLineHeight: Float;
            var line: Paint;
            if (i % 10 == 0) {
                theLineHeight = largeLineHeight
                line = largeLine
            } else if (i % 5 == 0) {
                theLineHeight = midLineHeight
                line = midLine
            } else {
                theLineHeight = smallLineHeight
                line = smallLine
            }

            canvas.drawLine(
                (i * mmToPixels()).toFloat() + x1, y2,
                (i * mmToPixels()).toFloat() + x1, (y2 - theLineHeight), line
            )
        }
    }
}