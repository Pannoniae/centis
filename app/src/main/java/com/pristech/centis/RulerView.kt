package com.pristech.centis

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class RulerView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    override fun onDraw(canvas: Canvas) {

        val deviceInfo = DeviceInfo(context)
        var lineSelector = LineSelector(LineType.NORMAL, deviceInfo)

        val xMargin = 0.25F * deviceInfo.cmToPixels()
        val yMargin = 0.25F * deviceInfo.cmToPixels()
        val x1 = 0.toFloat() + xMargin
        val x2 = width.toFloat() - yMargin
        val y1 = 0.toFloat() + yMargin
        val y2 = height.toFloat() - yMargin

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
        for (i in 0..deviceInfo.maxDeviceSizeInCm().toInt()) {
            canvas.drawTextCentred(
                i.toString(), (i * deviceInfo.cmToPixels()) + x1,
                y2 - largeLineHeight - yMargin, line
            )
        }

        // the lines
        for (i in (0..deviceInfo.maxDeviceSizeInCm().toInt() * 10)) {

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