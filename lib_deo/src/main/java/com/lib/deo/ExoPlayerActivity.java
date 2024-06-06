package com.lib.deo;

import android.os.Bundle;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.lib.base.BaseActivity;
import com.lib.deo.constants.Constants;
import com.lib.deo.manager.DeoCacheManager;

/**
 * ExoPlayer谷歌视频播放库
 */
public class ExoPlayerActivity extends BaseActivity {

    private SimpleExoPlayer mPlayer;
    private PlayerView mPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_exo_player);
        setActivityTitle("ExoPlayer Video");
        initView();
        initData();
    }

    private void initView() {
        mPlayerView = findViewById(R.id.player_view);
    }

    private void initData() {
        // 创建媒体播放器
        mPlayer = new SimpleExoPlayer.Builder(this).build();
        mPlayerView.setPlayer(mPlayer);

        MediaItem mediaItem = MediaItem.fromUri(DeoCacheManager.getInstance().getProxyUrl(Constants.VIDEO_URL));
        mPlayer.setMediaItem(mediaItem);
        mPlayer.prepare();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPlayerView.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPlayerView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayer.release();
    }
}