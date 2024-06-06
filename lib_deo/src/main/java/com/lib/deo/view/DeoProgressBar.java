package com.lib.deo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/8/3  10:10
 */
public class DeoProgressBar extends View {

    private Paint backgroundPaint;
    private Paint progressPaint;
    private float progress;
    private boolean isDragging;
    private float round = 0.0f;
    private OnProgressChangeListener progressChangeListener;

    public DeoProgressBar(Context context) {
        super(context);
        init(context);
    }

    public DeoProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DeoProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        backgroundPaint = new Paint();
        backgroundPaint.setColor(Color.GRAY);
        backgroundPaint.setAntiAlias(true);

        progressPaint = new Paint();
        progressPaint.setColor(Color.WHITE);
        progressPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        round = heightSpecSize / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制背景
        canvas.drawRoundRect(0, 0, getWidth(), getHeight(), round, round, backgroundPaint);

        // 根据进度绘制进度条
        float progressWidth = getWidth() * progress;
        canvas.drawRoundRect(0, 0, progressWidth, getHeight(), round, round, progressPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (x >= 0 && x <= getWidth() && y >= 0 && y <= getHeight()) {
                    isDragging = true;
                    updateProgress(x);
                    return true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (isDragging) {
                    updateProgress(x);
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                isDragging = false;
                if (progressChangeListener != null) {
                    progressChangeListener.onProgressChanged(progress);
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private void updateProgress(float x) {
        progress = Math.max(0, Math.min(x / getWidth(), 1));
        invalidate();
        if (progressChangeListener != null) {
            progressChangeListener.onProgressChanged(progress);
        }
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    public void setProgressChangeListener(OnProgressChangeListener listener) {
        this.progressChangeListener = listener;
    }

    public interface OnProgressChangeListener {
        void onProgressChanged(float progress);
    }
}
