package com.lib.deo.util

/**
 * @Author:  Jin
 * @Description:
 * @CreateDate: 2023/8/3  11:23
 */
class TimeUtil {
    companion object {
        @JvmStatic
        fun secondToDate(millisecond: Float): String {
            if (millisecond <= 0) {
                return "00:00"
            }
            val time: Int = (millisecond / 1000).toInt()
            val minute: Int = time / 60
            val second: Int = time % 60
            var dateSecond = second.toString()
            if (second < 10) {
                dateSecond = "0$second"
            }
            var dateMinute = minute.toString()
            if (minute < 10) {
                dateMinute = "0$minute"
            }
            return "$dateMinute:$dateSecond"
        }
    }
}