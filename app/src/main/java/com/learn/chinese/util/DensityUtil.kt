package com.learn.chinese.util;

import android.content.Context
import android.util.TypedValue

/**
 * @Author:  Jin
 * @Description:
 * @CreateDate: 2022/11/22  11:33
 */
class DensityUtil {
    companion object{
        /**
         * dp转px
         */
        @JvmStatic
        fun dp2px(context: Context, dpVal: Float): Int {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    dpVal, context.resources.displayMetrics).toInt()
        }

        /**
         * sp转px
         */
        @JvmStatic
        fun sp2px(context: Context, spVal: Float): Int {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                    spVal, context.resources.displayMetrics).toInt()
        }

        /**
         * px转dp
         */
        @JvmStatic
        fun px2dp(context: Context, pxVal: Float): Float {
            val scale = context.resources.displayMetrics.density
            return pxVal / scale
        }

        /**
         * px转sp
         */
        @JvmStatic
        fun px2sp(context: Context, pxVal: Float): Float {
            return pxVal / context.resources.displayMetrics.scaledDensity
        }
    }
}