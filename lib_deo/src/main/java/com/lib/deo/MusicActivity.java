package com.lib.deo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.lib.base.BaseActivity;
import com.lib.com.util.LogUtil;
import com.lib.deo.manager.MediaPlayManager;

import com.lib.deo.util.TimeUtil;
import com.lib.deo.view.DeoProgressBar;

public class MusicActivity extends BaseActivity {
    private static final String TAG = "MusicActivity";
    private ImageView imgPlay;
    private boolean playMusic = false;
    private int first = 0;

    private TextView textPlayTime;
    private TextView textAllTime;
    private DeoProgressBar progressMusic;

    private ImageView imgDisc;
    private ImageView imgNeedle;
    private ObjectAnimator discAnimation, needleAnimation, needleStopAnimation;

    private MediaPlayManager mMediaPlayManager;

    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_music);
        setActivityTitle("MediaPlayer Audio");
        initView();
        setAnimations();
        initData();
    }

    private void initView() {
        imgPlay = findViewById(R.id.img_play);
        imgPlay.setOnClickListener(v -> {
            playMusic = !playMusic;
            if (playMusic) {
                imgPlay.setImageResource(R.mipmap.ic_music_pause);
                needleAnimation.start();
                if (first == 0) {
                    discAnimation.start();
                } else {
                    discAnimation.resume();
                }
                postDelayed();
            } else {
                imgPlay.setImageResource(R.mipmap.ic_music_start);
                needleStopAnimation.start();
                discAnimation.pause();
                mHandler.removeCallbacksAndMessages(null);
                mRunnable = null;
            }
            // 播放或暂停音乐
            mMediaPlayManager.startOrPauseMusic();
            first++;
        });

        textPlayTime = findViewById(R.id.text_play_time);
        textAllTime = findViewById(R.id.text_all_time);
        progressMusic = findViewById(R.id.progress_music);
        progressMusic.setProgressChangeListener(progress -> {
            float duration = MediaPlayManager.getInstance().getDuration();
            int seek = (int) (duration * progress);
            LogUtil.i(TAG, "onProgressChanged seek:" + seek);
            MediaPlayManager.getInstance().seekTo(seek);
        });

        imgDisc = findViewById(R.id.img_disc);
        imgNeedle = findViewById(R.id.img_needle);
    }

    // 动画设置
    private void setAnimations() {
        discAnimation = ObjectAnimator.ofFloat(imgDisc, "rotation", 0, 360);
        discAnimation.setDuration(10000);
        discAnimation.setInterpolator(new LinearInterpolator());
        discAnimation.setRepeatCount(ValueAnimator.INFINITE);

        needleAnimation = ObjectAnimator.ofFloat(imgNeedle, "rotation", 0, 25);
        imgNeedle.setPivotX(0);
        imgNeedle.setPivotY(0);
        needleAnimation.setDuration(800);
        needleAnimation.setInterpolator(new LinearInterpolator());

        needleStopAnimation = ObjectAnimator.ofFloat(imgNeedle, "rotation", 25, 0);
        imgNeedle.setPivotX(0);
        imgNeedle.setPivotY(0);
        needleStopAnimation.setDuration(800);
        needleStopAnimation.setInterpolator(new LinearInterpolator());
    }

    private void initData() {
        mHandler = new Handler();

        mMediaPlayManager = MediaPlayManager.getInstance();
        playMusic = mMediaPlayManager.isPlaying();
        if (playMusic) {
            imgPlay.setImageResource(R.mipmap.ic_music_pause);
            needleAnimation.start();
            discAnimation.start();
            updateProgress();
            postDelayed();
        } else {
            imgPlay.setImageResource(R.mipmap.ic_music_start);
        }
    }

    private void updateUI() {
        if (!playMusic) {
            playMusic = true;
            imgPlay.setImageResource(R.mipmap.ic_music_pause);
            needleAnimation.start();
            if (first == 0) {
                discAnimation.start();
            } else {
                discAnimation.resume();
            }
            postDelayed();
        }
    }

    private void postDelayed() {
        mHandler.removeCallbacksAndMessages(null);
        mRunnable = new Runnable() {
            @Override
            public void run() {
                updateProgress();
                mHandler.postDelayed(this, 1000);
            }
        };
        mHandler.postDelayed(mRunnable, 1000);
    }

    private void updateProgress() {
        float currentPosition = MediaPlayManager.getInstance().getCurrentPosition();
        float duration = MediaPlayManager.getInstance().getDuration();
        float progress = currentPosition / duration;
        LogUtil.i(TAG, "updateProgress currentPosition:" + currentPosition + ",duration:" + duration);
        LogUtil.i(TAG, "updateProgress progress:" + progress);
        progressMusic.setProgress(progress);
        textPlayTime.setText(TimeUtil.secondToDate(currentPosition));
        textAllTime.setText(TimeUtil.secondToDate(duration));
    }

    public void onNext(View view) {
        MediaPlayManager.getInstance().next();
        updateUI();
    }

    public void onUp(View view) {
        MediaPlayManager.getInstance().up();
        updateUI();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
            mHandler = null;
        }
        if (mRunnable != null) {
            mRunnable = null;
        }
    }
}