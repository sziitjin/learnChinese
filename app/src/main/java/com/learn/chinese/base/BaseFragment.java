package com.learn.chinese.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.learn.chinese.design.mode.observer.Observer;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/26  14:38
 */
public class BaseFragment extends Fragment implements View.OnClickListener, Observer {

    protected Context mContext;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this.getContext();
    }

    @Override
    public void update(String message) {

    }

    @Override
    public void onClick(View v) {

    }
}
