package com.lib.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lib.base.util.StatusBar;


/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/6  9:42
 */
public class BaseActivity extends AppCompatActivity {

    private ImageView ivBaseBack;
    private TextView tvBaseTitle;
    private FrameLayout baseContent;
    protected View contentView;

    private ImageView ivRightIcon;
    private TextView tvRightTitle;

    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        StatusBar.fullScreen(this, false);
        StatusBar.setAndroidNativeLightStatusBar(this, false);
        mContext = this;
        init();
    }

    private void init() {
        ivBaseBack = (ImageView) findViewById(R.id.iv_base_back);
        tvBaseTitle = (TextView) findViewById(R.id.tv_base_title);
        baseContent = (FrameLayout) findViewById(R.id.base_content);
        ivBaseBack.setOnClickListener(mClickListener);

        ivRightIcon = (ImageView) findViewById(R.id.iv_right_icon);
        tvRightTitle = (TextView) findViewById(R.id.tv_right_title);
        ivRightIcon.setOnClickListener(mClickListener);
        tvRightTitle.setOnClickListener(mClickListener);

        //在有需要的页面打开
        ivRightIcon.setVisibility(View.GONE);
        tvRightTitle.setVisibility(View.GONE);
    }

    public void setActivityTitle(String title){
        tvBaseTitle.setText(title);
    }

    public void setBaseContentView(int layoutId) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        contentView = inflater.inflate(layoutId, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);
        contentView.setLayoutParams(layoutParams);
        baseContent.addView(contentView);
    }

    private View.OnClickListener mClickListener = v -> {
        int id = v.getId();
        if (id == R.id.iv_base_back) {
            OnBackClick();
        } else if (id == R.id.iv_right_icon || id == R.id.tv_right_title) {
            OnRightTopMenuClick();
        }
    };

    public void OnBackClick() {
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void OnRightTopMenuClick() {
    }
}
