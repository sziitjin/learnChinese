package com.lib.deo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.SurfaceTexture;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;

import com.lib.base.BaseActivity;
import com.lib.deo.constants.Constants;
import com.lib.deo.manager.DeoCacheManager;

import java.io.IOException;

/**
 * MediaPlayer+TextureView
 */
public class MediaTextureActivity extends BaseActivity implements TextureView.SurfaceTextureListener,
        MediaPlayer.OnPreparedListener {

    private TextureView textureView;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_media_texture);
        setActivityTitle("MediaPlayer TextureView Video");
        initView();
        initData();
    }

    private void initView() {
        textureView = findViewById(R.id.textureView);
        textureView.setSurfaceTextureListener(this);
    }

    private void initData() {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
    }

    @Override
    public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surfaceTexture, int width, int height) {
        // 当 TextureView 可用时，设置 Surface 给 MediaPlayer
        Surface surface = new Surface(surfaceTexture);
        mediaPlayer.setSurface(surface);
        surface.release();

        // 设置音频播放属性
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MOVIE)
                .build();
        mediaPlayer.setAudioAttributes(audioAttributes);

        try {
            mediaPlayer.setDataSource(DeoCacheManager.getInstance().getProxyUrl(Constants.VIDEO_URL)); // 设置要播放的 url 音频文件
            mediaPlayer.prepareAsync(); // 异步准备 MediaPlayer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface, int width, int height) {
        // 当 TextureView 大小改变时，处理相应的逻辑
    }

    @Override
    public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) {
        // 当 TextureView 销毁时，释放 MediaPlayer 相关资源
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {
        // 当 TextureView 更新时，处理相应的逻辑
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        // 当 MediaPlayer 准备完成时，开始播放视频
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }
}