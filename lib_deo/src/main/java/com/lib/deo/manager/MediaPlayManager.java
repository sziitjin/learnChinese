package com.lib.deo.manager;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

import com.lib.deo.DeoApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/12  10:10
 */
public class MediaPlayManager {
    private static final String TAG = "MediaPlayManager";

    private MediaPlayer mediaPlayer;

    private List<String> audioUrls = new ArrayList<>(); // 设置要播放的 url 音频文件列表
    private int currentAudioIndex = 0; // 当前播放的音频文件索引
    private boolean first = true; // 首次不播放

    public static MediaPlayManager getInstance() {
        return MediaPlayHelper.mMediaPlayManager;
    }

    private static class MediaPlayHelper {
        private static final MediaPlayManager mMediaPlayManager = new MediaPlayManager();
    }

    public MediaPlayManager() {
        init();
    }

    private void init() {
        // 创建 MediaPlayer 对象
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        setDefaultAudioUrls();
        // 监听播放完成
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                currentAudioIndex++;
                // 全部歌曲播放完成，循环播放
                if (currentAudioIndex >= audioUrls.size()) {
                    currentAudioIndex = 0;
                }
                try {
                    mediaPlayer.reset(); // 重置 MediaPlayer
                    mediaPlayer.setDataSource(getAudioUrl(currentAudioIndex)); // 设置要播放的 url 音频文件
                    mediaPlayer.prepareAsync(); // 异步准备 MediaPlayer
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            //异步准备监听
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (!first) {
                    mediaPlayer.start(); // 播放
                }
                first = false;
            }
        });

        try {
            mediaPlayer.setDataSource(getAudioUrl(currentAudioIndex)); // 设置要播放的 url 音频文件
            mediaPlayer.prepareAsync(); // 异步准备 MediaPlayer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAudioUrl(int index) {
        String oldUrl = audioUrls.get(index);
        String newUrl = DeoCacheManager.getInstance().getProxy().getProxyUrl(oldUrl);
        Log.i(TAG, "getAudioUrl oldUrl:" + oldUrl);
        Log.i(TAG, "getAudioUrl newUrl:" + newUrl);
        return newUrl;
    }

    public void setDefaultAudioUrls() {
        if (audioUrls.size() == 24) return;
        audioUrls.clear();
        audioUrls.add("https://assets.sweetsteps.app/BGM-1.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-2.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-3.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-4.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-5.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-6.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-7.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-8.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-9.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-10.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-11.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-12.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-13.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-14.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-15.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-16.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-17.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-18.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-19.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-20.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-21.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-22.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-23.mp3");
        audioUrls.add("https://assets.sweetsteps.app/BGM-24.mp3");
    }

    /**
     * 播放或暂停音乐
     */
    public void startOrPauseMusic() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.start();
        }
    }

    public void next() {
        currentAudioIndex++;
        if (currentAudioIndex >= audioUrls.size()) {
            currentAudioIndex = 0;
        }
        try {
            mediaPlayer.reset(); // 重置 MediaPlayer
            mediaPlayer.setDataSource(getAudioUrl(currentAudioIndex)); // 设置要播放的 url 音频文件
            mediaPlayer.prepareAsync(); // 异步准备 MediaPlayer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void up() {
        currentAudioIndex--;
        if (currentAudioIndex < 0) {
            currentAudioIndex = audioUrls.size() - 1;
        }
        try {
            mediaPlayer.reset(); // 重置 MediaPlayer
            mediaPlayer.setDataSource(getAudioUrl(currentAudioIndex)); // 设置要播放的 url 音频文件
            mediaPlayer.prepareAsync(); // 异步准备 MediaPlayer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    public int getCurrentPosition() {
        return mediaPlayer.getCurrentPosition();
    }

    public int getDuration() {
        return mediaPlayer.getDuration();
    }

    public void seekTo(int progress) {
        mediaPlayer.seekTo(progress);
    }

    public void release() {
        // 释放 MediaPlayer 对象的资源
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
