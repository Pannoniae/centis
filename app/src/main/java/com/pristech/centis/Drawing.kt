package com.pristech.centis

import android.graphics.Color
import android.graphics.Paint
import kotlin.math.max


enum class LineType {

    NORMAL {
        override fun size(deviceInfo: DeviceInfo): Float {
            return 0.5F * deviceInfo.cmToPixels()
        }

    },
    SMALL {
        override fun size(deviceInfo: DeviceInfo): Float {
            return max(0.025F * deviceInfo.cmToPixels(), 1F)
        }
    },
    MEDIUM {
        override fun size(deviceInfo: DeviceInfo): Float {
            return 0.05F * deviceInfo.cmToPixels()
        }
    },
    LARGE {
        override fun size(deviceInfo: DeviceInfo): Float {
            return 0.1F * deviceInfo.cmToPixels()

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
    var line = when (lineType) {
        LineType.NORMAL -> Paint().apply {
            color = Color.BLACK
            strokeWidth = lineType.size(deviceInfo)
            strokeCap = Paint.Cap.ROUND
        }
        LineType.SMALL -> Paint().apply {
            color = Color.BLACK
            strokeWidth = lineType.size(deviceInfo)
        }
        LineType.MEDIUM -> Paint().apply {
            color = Color.BLACK
            strokeWidth = lineType.size(deviceInfo)
        }
        LineType.LARGE -> Paint().apply {
            color = Color.BLACK
            strokeWidth = lineType.size(deviceInfo)
        }
        LineType.NUMBERS -> Paint().apply {
            color = Color.RED
            textSize = lineType.size(deviceInfo)
        }


    }
}
