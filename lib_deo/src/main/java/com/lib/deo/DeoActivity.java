package com.lib.deo;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lib.base.BaseActivity;
import com.lib.deo.adapter.ListAdapter;
import com.lib.deo.manager.MediaPlayManager;

import java.util.ArrayList;
import java.util.List;

public class DeoActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_deo);
        setActivityTitle("AudioVideoCamera");
        initView();
        initData();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        int count = recyclerView.getItemDecorationCount();
        for (int i = 0; i < count; i++) {
            recyclerView.removeItemDecorationAt(i);
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        listAdapter = new ListAdapter(this);
        recyclerView.setAdapter(listAdapter);
        listAdapter.setOnItemClickListener(position -> {
            if (position == 0) {
                startActivity(new Intent(mContext, MusicActivity.class));
            } else if (position == 1) {
                startActivity(new Intent(mContext, MediaSurfaceActivity.class));
            } else if (position == 2) {
                startActivity(new Intent(mContext, VideoViewActivity.class));
            } else if (position == 3) {
                startActivity(new Intent(mContext, MediaTextureActivity.class));
            } else if (position == 4) {
                startActivity(new Intent(mContext, ExoPlayerActivity.class));
            } else if (position == 5) {
                startActivity(new Intent(mContext, GSYVideoActivity.class));
            }
        });
    }

    private void initData() {
        List<String> data = new ArrayList<>();
        data.add("MediaPlayer Audio");
        data.add("MediaPlayer SurfaceView Video");
        data.add("VideoView Video");
        data.add("MediaPlayer TextureView Video");
        data.add("ExoPlayer Video");
        data.add("GSYVideoPlayer");
        listAdapter.setData(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MediaPlayManager.getInstance().release();
    }
}