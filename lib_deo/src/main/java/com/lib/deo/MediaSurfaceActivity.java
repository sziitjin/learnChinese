package com.lib.deo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.lib.base.BaseActivity;
import com.lib.deo.constants.Constants;
import com.lib.deo.manager.DeoCacheManager;

import java.io.IOException;

/**
 * MediaPlayer+SurfaceView
 */
public class MediaSurfaceActivity extends BaseActivity implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {
    private static final String TAG = "MediaSurfaceActivity";
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_media_surface);
        setActivityTitle("MediaPlayer SurfaceView Video");
        initView();
        initData();
    }

    private void initView() {
        surfaceView = findViewById(R.id.surfaceView);
    }

    private void initData() {
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        try {
            mediaPlayer.setDataSource(DeoCacheManager.getInstance().getProxyUrl(Constants.VIDEO_URL)); // 设置要播放的 url 音频文件
            mediaPlayer.prepareAsync(); // 异步准备 MediaPlayer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        mediaPlayer.setDisplay(holder);
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

}