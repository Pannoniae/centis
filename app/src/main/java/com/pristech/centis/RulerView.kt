package com.pristech.centis

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.roundToInt


class RulerView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    override fun onDraw(canvas: Canvas) {

        val deviceInfo = DeviceInfo(context)
        var lineSelector = LineSelector(LineType.NORMAL, deviceInfo)

        val x1 = 0.toFloat() + deviceInfo.xMargin()
        val x2 = width.toFloat() - deviceInfo.yMargin()
        val y1 = 0.toFloat() + deviceInfo.yMargin()
        val y2 = height.toFloat() - deviceInfo.yMargin()

        val smallLineHeight = 1F * deviceInfo.cmToPixels()
        val midLineHeight = 1.25F * deviceInfo.cmToPixels()
        val largeLineHeight = 1.5F * deviceInfo.cmToPixels()

        var theLineHeight: Float
        var line: Paint

        line = lineSelector.choose(LineType.NORMAL)
        // bottom line
        canvas.drawLine(x1, y2, x2, y2, line)
        // numbers
        line = lineSelector.choose(LineType.NUMBERS)

        var maxSizeInCm: Int = deviceInfo.maxDeviceSizeInCm().toInt() - 1;
        // round down
        if ((maxSizeInCm % 2) != 0) {
            maxSizeInCm -= 1;
        }
        for (i in 0..maxSizeInCm) {
            canvas.drawTextCentred(
                i.toString(), (i * deviceInfo.cmToPixels()) + x1,
                y2 - largeLineHeight - deviceInfo.yMargin(), line
            )
        }

        // the lines
        for (i in (0..maxSizeInCm * 10)) {

            if (i % 10 == 0) {
                theLineHeight = largeLineHeight
                line = lineSelector.choose(LineType.NORMAL)
            } else if (i % 5 == 0) {
                theLineHeight = midLineHeight
                line = lineSelector.choose(LineType.MEDIUM)
            } else {
                theLineHeight = smallLineHeight
                line = lineSelector.choose(LineType.SMALL)
            }

            canvas.drawLine(
                (i * deviceInfo.mmToPixels()) + x1, y2,
                (i * deviceInfo.mmToPixels()) + x1, (y2 - theLineHeight), line
            )
        }
    }
}