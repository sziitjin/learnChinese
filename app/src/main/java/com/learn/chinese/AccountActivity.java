package com.learn.chinese;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.learn.chinese.design.mode.observer.ObservableImpl;
import com.learn.chinese.util.SharedPre;
import com.learn.chinese.util.SkProvider;
import com.learn.chinese.util.UuidUtil;
import com.learn.chinese.util.ValidatorUtil;
import com.lib.base.BaseActivity;

public class AccountActivity extends BaseActivity {
    private EditText etAccount;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_account);
        setActivityTitle(getString(R.string.account));
        initView();
        initData();
    }

    private void initView() {
        etAccount = findViewById(R.id.et_account);
        etAccount.setOnTouchListener((v, event) -> {
            Drawable drawable = etAccount.getCompoundDrawables()[2];
            if (drawable == null)
                return false;
            if (event.getAction() != MotionEvent.ACTION_UP)
                return false;
            if (event.getX() > etAccount.getWidth()
                    - etAccount.getPaddingRight()
                    - drawable.getIntrinsicWidth()) {
                etAccount.getText().clear();
            }
            return false;
        });


        btnReset = findViewById(R.id.btn_reset);
        btnReset.setOnClickListener(v -> setAccount(etAccount.getText().toString().trim()));
    }

    private void setAccount(String account) {
        if (TextUtils.isEmpty(account)) {
            Toast.makeText(mContext, getString(R.string.account_not_null), Toast.LENGTH_SHORT).show();
            return;
        }
        if (!ValidatorUtil.isEmail(account)) {
            Toast.makeText(mContext, getString(R.string.hint_email_1), Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPre.getInstance().putString("account", account);
        ObservableImpl.getInstance().notifyObserver(account, "setting");
        finish();
    }

    private void initData() {
        String account = SkProvider.getString(mContext, "account");
        Log.i("AccountActivity", "initData account:" + account);
        if (TextUtils.isEmpty(account)) {
            account = UuidUtil.getUUID(10);
            SharedPre.getInstance().putString("account", account);
        }
        etAccount.setText(account);
    }
}