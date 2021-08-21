package com.pristech.centis

import android.graphics.Color
import android.graphics.Paint
import kotlin.math.max


enum class LineType {

    NORMAL {
        override fun size(deviceInfo: DeviceInfo): Float {
            return 0.05F * deviceInfo.cmToPixels()
        }

    },
    SMALL {
        override fun size(deviceInfo: DeviceInfo): Float {
            return max(0.0025F * deviceInfo.cmToPixels(), 1F)
        }
    },
    MEDIUM {
        override fun size(deviceInfo: DeviceInfo): Float {
            return max(0.005F * deviceInfo.cmToPixels(), 1F)
        }
    },
    LARGE {
        override fun size(deviceInfo: DeviceInfo): Float {
            return 0.01F * deviceInfo.cmToPixels()

        }
    },
    NUMBERS {
        override fun size(deviceInfo: DeviceInfo): Float {
            return 0.5F * deviceInfo.cmToPixels()
        }
    };

    abstract fun size(deviceInfo: DeviceInfo): Float
}

data class LineSelector(
    var lineType: LineType,
    val deviceInfo: DeviceInfo
) {
    fun choose(lineType: LineType) = when (lineType) {
        LineType.NORMAL -> Paint().apply {
            color = Color.BLACK
            strokeWidth = LineType.NORMAL.size(deviceInfo)
            strokeCap = Paint.Cap.ROUND
        }
        LineType.SMALL -> Paint().apply {
            color = Color.BLACK
            strokeWidth = LineType.SMALL.size(deviceInfo)
        }
        LineType.MEDIUM -> Paint().apply {
            color = Color.BLACK
            strokeWidth = LineType.MEDIUM.size(deviceInfo)
        }
        LineType.LARGE -> Paint().apply {
            color = Color.BLACK
            strokeWidth = LineType.LARGE.size(deviceInfo)
        }
        LineType.NUMBERS -> Paint().apply {
            color = Color.BLACK
            textSize = LineType.NUMBERS.size(deviceInfo)
        }


    }
}
