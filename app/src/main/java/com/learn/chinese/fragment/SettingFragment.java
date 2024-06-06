package com.learn.chinese.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.learn.chinese.AccountActivity;
import com.learn.chinese.NicknameActivity;
import com.learn.chinese.R;
import com.learn.chinese.base.BaseFragment;
import com.learn.chinese.design.mode.observer.ObservableImpl;
import com.learn.chinese.manager.PayManager;
import com.learn.chinese.util.SharedPre;
import com.learn.chinese.util.UuidUtil;

import org.jetbrains.annotations.NotNull;

public class SettingFragment extends BaseFragment {

    private TextView textNickname;
    private TextView textAccount;

    public static SettingFragment newInstance() {
        SettingFragment fragment = new SettingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ObservableImpl.getInstance().addObserver(this, "setting");
        initView(view);
        initData();
    }

    private void initView(View view) {
        textNickname = view.findViewById(R.id.text_nickname);
        textAccount = view.findViewById(R.id.text_account);
        view.findViewById(R.id.lin_nickname).setOnClickListener(v -> changeNickname());
        view.findViewById(R.id.lin_account).setOnClickListener(v -> changeAccount());
        view.findViewById(R.id.lin_share).setOnClickListener(v -> toShare());
        view.findViewById(R.id.lin_comment).setOnClickListener(v -> toComment());
        view.findViewById(R.id.lin_appreciate).setOnClickListener(v -> toAppreciate());
    }

    private void initData() {
        String nickname = SharedPre.getInstance().getString("nick_name");
        if (TextUtils.isEmpty(nickname)) {
            nickname = "CN" + UuidUtil.getUUID();
            SharedPre.getInstance().putString("nick_name", nickname);
        }
        textNickname.setText(nickname);

        String account = SharedPre.getInstance().getString("account");
        if (TextUtils.isEmpty(account)) {
            account = UuidUtil.getUUID(10);
            SharedPre.getInstance().putString("account", account);
        }
        textAccount.setText(account);
    }

    private void changeNickname() {
        startActivity(new Intent(mContext, NicknameActivity.class));
    }

    private void changeAccount() {
        startActivity(new Intent(mContext, AccountActivity.class));
    }

    private void toShare() {
        String urlToShare = getString(R.string.url_learn_chinese);
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
        shareIntent.putExtra(Intent.EXTRA_TEXT, urlToShare);
        startActivity(Intent.createChooser(shareIntent, getString(R.string.app_name)));
    }

    private void toComment() {
        String APP_PACKAGE_NAME = "com.learn.chinese.sk";
        Uri uri = Uri.parse("market://details?id=" + APP_PACKAGE_NAME);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        if (mContext.getPackageManager().resolveActivity(intent, 0) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(mContext, "Google Play app store not found.", Toast.LENGTH_SHORT).show();
        }
    }

    private void toAppreciate() {
        PayManager.getInstance().pay("learn.chinese.sk.001", "com.learn.chinese.sk.001", (Activity) mContext);
    }

    @Override
    public void update(String message) {
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ObservableImpl.getInstance().removeObserver(this);
    }
}