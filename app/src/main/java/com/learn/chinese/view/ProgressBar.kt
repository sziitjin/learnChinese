package com.learn.chinese.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.learn.chinese.R
import com.learn.chinese.util.DensityUtil


/**
 * @Author:  Jin
 * @Description:
 * @CreateDate: 2023/1/3  14:11
 */
class ProgressBar : View {
    private var mPaint: Paint? = null
    private var mPaintRoundRect: Paint? = null
    private var mPaintText: Paint? = null
    private var mWidth = 0
    private var mHeight = 0
    private var textSize = 15.0f
    private var round = 0.0f
    private var process = 0.0f
    private val defaultHeight = 10.0f
    private var showText = false

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init(context, attributeSet)
    }

    fun init(context: Context, attrs: AttributeSet?) {
        mPaintRoundRect = Paint() //外框圆角矩形
        mPaintRoundRect!!.color = resources.getColor(R.color.gray_e4) //圆角矩形颜色
        mPaintRoundRect!!.isAntiAlias = true // 抗锯齿效果
        mPaintRoundRect!!.style = Paint.Style.FILL_AND_STROKE //设置画笔样式

        mPaint = Paint() //内框圆角矩形
        mPaint!!.color = resources.getColor(R.color.item2_color)
        mPaint!!.style = Paint.Style.FILL_AND_STROKE
        mPaint!!.isAntiAlias = true

        mPaintText = Paint()
        mPaintText!!.isAntiAlias = true
        mPaintText!!.style = Paint.Style.FILL
        mPaintText!!.color = resources.getColor(R.color.black)
        mPaintText!!.textSize = defaultTextSize()
        attrs?.let {
            val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.ProgressBar, 0, 0)
            try {
                mPaintRoundRect!!.color = typedArray.getColor(R.styleable.ProgressBar_roundColor, resources.getColor(R.color.gray_e4))
                mPaint!!.color = typedArray.getColor(R.styleable.ProgressBar_progressColor, resources.getColor(R.color.item2_color))
                mPaintText!!.color = typedArray.getColor(R.styleable.ProgressBar_textColor, resources.getColor(R.color.black))
                round = typedArray.getDimensionPixelSize(R.styleable.ProgressBar_radiusSize, 12).toFloat()
                showText = typedArray.getBoolean(R.styleable.ProgressBar_textEnabled, false)
            } finally {
                typedArray.recycle()
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthSpecMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightSpecMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthSpecSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSpecSize = MeasureSpec.getSize(heightMeasureSpec)
        when (widthSpecMode) {
            // 精确尺寸，match_parent 或 10dp
            MeasureSpec.EXACTLY -> mWidth = widthSpecSize
            // warp_parent，<= 父布局的大小
            MeasureSpec.AT_MOST -> mWidth = widthSpecSize
        }
        when (heightSpecMode) {
            // 精确尺寸，match_parent 或 10dp
            MeasureSpec.EXACTLY -> mHeight = heightSpecSize
            // warp_parent，<= 父布局的大小
            MeasureSpec.AT_MOST -> mWidth = defaultHeight()
            else -> defaultHeight()
        }
        //设置控件实际大小
        setMeasuredDimension(mWidth, mHeight)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawBackground(canvas) //绘制背景矩形
        drawProgress(canvas) //绘制进度
        updateText(canvas) //处理文字
    }

    private fun drawBackground(canvas: Canvas?) {
        val rectF = RectF(0F, 0F, mWidth.toFloat(), mHeight.toFloat()) //圆角矩形
        canvas?.drawRoundRect(rectF, round, round, mPaintRoundRect!!)
    }

    private fun drawProgress(canvas: Canvas?) {
        if (process.toInt() != 0) {
            val right = mWidth * process / 100
            val rectProgress = RectF(0F, 0F, right, mHeight.toFloat()) //内部进度条
            canvas?.drawRoundRect(rectProgress, round, round, mPaint!!)
        }
    }

    private fun updateText(canvas: Canvas?) {
        if (!showText) {
            return
        }
        var percent = (process / mWidth * 100).toInt()
        if (percent > 100) {
            percent = 100
        }
        val percentText = "$percent%"
        val fm = mPaintText?.fontMetrics
        val mTxtWidth = mPaintText!!.measureText(percentText, 0, percentText.length)?.toInt()
        val mTxtHeight = Math.ceil((fm?.descent!! - fm?.ascent!!).toDouble()).toInt()
        val x = width / 2 - mTxtWidth / 2 //文字在画布中的x坐标
        val y = height / 2 + mTxtHeight / 4 //文字在画布中的y坐标
        canvas?.drawText(percentText, x.toFloat(), y.toFloat(), mPaintText!!)
    }

    fun setProgress(process: Float) {
        this.process = process
        invalidate()
    }

    private fun defaultHeight(): Int {
        return DensityUtil.dp2px(context, defaultHeight)
    }

    private fun defaultTextSize(): Float {
        return DensityUtil.sp2px(context, textSize).toFloat()
    }
}