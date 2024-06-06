package com.lib.deo.manager;

import android.util.Log;

import com.danikula.videocache.HttpProxyCacheServer;
import com.lib.com.util.FileUtil;
import com.lib.deo.DeoApp;

import java.io.File;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/8/3  9:46
 */
public class DeoCacheManager {

    private static final String TAG = "DeoCacheManager";

    private HttpProxyCacheServer proxy;

    public static DeoCacheManager getInstance() {
        return DeoCacheHelper.deoCacheManager;
    }

    private static class DeoCacheHelper {
        private static final DeoCacheManager deoCacheManager = new DeoCacheManager();
    }

    public HttpProxyCacheServer getProxy() {
        return proxy == null ? (proxy = newProxy()) : proxy;
    }

    private HttpProxyCacheServer newProxy() {
        File audio = new File(FileUtil.getCacheDir(DeoApp.getContext()) + "/audio_cache");
        return new HttpProxyCacheServer.Builder(DeoApp.getContext())
                // 设置音视频缓存路径
                .cacheDirectory(audio)
                .build();
    }

    public String getProxyUrl(String oldUrl){
        String newUrl = DeoCacheManager.getInstance().getProxy().getProxyUrl(oldUrl);
        Log.i(TAG, "getAudioUrl oldUrl:" + oldUrl);
        Log.i(TAG, "getAudioUrl newUrl:" + newUrl);
        return newUrl;
    }
}
