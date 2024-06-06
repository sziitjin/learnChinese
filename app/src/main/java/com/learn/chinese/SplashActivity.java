package com.learn.chinese;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.lib.base.util.StatusBar;
import com.lib.deo.DeoActivity;

public class SplashActivity extends AppCompatActivity {
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StatusBar.fullScreen(this, false);
        StatusBar.setAndroidNativeLightStatusBar(this, false);
        mHandler = new Handler();
        init();
    }

    private void init() {
        mHandler.postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainNewActivity.class));
            //startActivity(new Intent(SplashActivity.this, DeoActivity.class));
            finish();
        }, 2000);
    }
}