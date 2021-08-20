package com.pristech.centis

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.max

class RulerView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    override fun onDraw(canvas: Canvas) {

        val xMargin = 0.25F * cmToPixels()
        val yMargin = 0.25F * cmToPixels()

        val x1 = 0.toFloat() + xMargin
        val x2 = width.toFloat() - yMargin
        val y1 = 0.toFloat() + yMargin
        val y2 = height.toFloat()  - yMargin

        val smallLineHeight = 1F * cmToPixels()
        val midLineHeight = 1.25F * cmToPixels()
        val largeLineHeight = 1.5F * cmToPixels()

        // bottom line
        canvas.drawLine(x1, y2, x2, y2, Lines.LINE.line)
        // numbers
        for (i in 0..getMaxDeviceSizeInCm()) {
            canvas.drawTextCentred(
                i.toString(), (i * cmToPixels()).toFloat() + x1,
                y2 - largeLineHeight - yMargin, Lines.NUMBERS.line
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
                line = Lines.LARGE.line
            } else if (i % 5 == 0) {
                theLineHeight = midLineHeight
                line = Lines.MEDIUM.line
            } else {
                theLineHeight = smallLineHeight
                line = Lines.SMALL.line
            }

            canvas.drawLine(
                (i * mmToPixels()).toFloat() + x1, y2,
                (i * mmToPixels()).toFloat() + x1, (y2 - theLineHeight), line
            )
        }
    }
}