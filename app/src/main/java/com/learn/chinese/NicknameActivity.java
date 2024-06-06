package com.learn.chinese;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.learn.chinese.design.mode.observer.ObservableImpl;
import com.learn.chinese.util.SharedPre;
import com.learn.chinese.util.UuidUtil;
import com.lib.base.BaseActivity;

public class NicknameActivity extends BaseActivity {

    private EditText etNickname;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_nickname);
        setActivityTitle(getString(R.string.nick_name));
        initView();
        initData();
    }

    private void initView() {
        etNickname = findViewById(R.id.et_nickname);
        etNickname.setOnTouchListener((v, event) -> {
            Drawable drawable = etNickname.getCompoundDrawables()[2];
            if (drawable == null)
                return false;
            if (event.getAction() != MotionEvent.ACTION_UP)
                return false;
            if (event.getX() > etNickname.getWidth()
                    - etNickname.getPaddingRight()
                    - drawable.getIntrinsicWidth()) {
                etNickname.getText().clear();
            }
            return false;
        });


        btnReset = findViewById(R.id.btn_reset);
        btnReset.setOnClickListener(v -> setNickname(etNickname.getText().toString().trim()));
    }

    private void setNickname(String nickname) {
        if (TextUtils.isEmpty(nickname)) {
            Toast.makeText(mContext, getString(R.string.nickname_not_null), Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPre.getInstance().putString("nick_name", nickname);
        ObservableImpl.getInstance().notifyObserver(nickname, "setting");
        finish();
    }

    private void initData() {
        String nickname = SharedPre.getInstance().getString("nick_name");
        if (TextUtils.isEmpty(nickname)) {
            nickname = "CN" + UuidUtil.getUUID();
            SharedPre.getInstance().putString("nick_name", nickname);
        }
        etNickname.setText(nickname);
    }
}