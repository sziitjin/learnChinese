package com.lib.deo;


import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.lib.base.BaseActivity;
import com.lib.deo.constants.Constants;

/**
 * VideoView = MediaPlayer+SurfaceView
 */
public class VideoViewActivity extends BaseActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_video_view);
        setActivityTitle("VideoView Video");
        initView();
        initData();
    }

    private void initView() {
        videoView = findViewById(R.id.video_view);
    }

    private void initData() {
        // 创建 MediaController 并关联 VideoView
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        String videoUrl  = Constants.VIDEO_URL;
        setData(Uri.parse(videoUrl));
    }

    private void setData(Uri uri) {
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setOnCompletionListener(mp -> videoView.start());
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoView.stopPlayback();
    }
}