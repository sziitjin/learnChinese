package com.learn.chinese;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.chinese.adapter.LearnListAdapter;
import com.learn.chinese.bean.LearnData;
import com.learn.chinese.data.LearnDataFactory;
import com.lib.base.BaseActivity;

import java.util.Locale;

public class LearnItemActivity extends BaseActivity {
    private static final String TAG = "LearnItemActivity";
    private RecyclerView recyclerView;
    private LearnListAdapter listAdapter;

    private TextToSpeech mTextToSpeech;
    private LearnData mLearnData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_learn_item);
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
        listAdapter = new LearnListAdapter(this);
        recyclerView.setAdapter(listAdapter);
        listAdapter.setOnItemClickListener(learnData -> {
            this.mLearnData = learnData;
            speak(mLearnData.getZhName());
        });
    }

    private void initData() {
        String zhName = getIntent().getStringExtra("zhName");
        String enName = getIntent().getStringExtra("enName");
        setActivityTitle(zhName + "（" + enName + "）");
        int type = getIntent().getIntExtra("type", 0);
        listAdapter.setData(LearnDataFactory.makeLearnData(type));

        mTextToSpeech = new TextToSpeech(mContext, status -> {
            if (status == TextToSpeech.SUCCESS) {
                mTextToSpeech.setOnUtteranceProgressListener(new TtsProgress());
                // 设置音调，1.0是常规（范围0.5到2.0）
                mTextToSpeech.setPitch(1.0f);
                // 设定语速，默认1.0正常语速（范围为0.1到2.0）
                mTextToSpeech.setSpeechRate(0.8f);
                int result = mTextToSpeech.setLanguage(Locale.getDefault());
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e(TAG, "TextToSpeech：This language is not supported");
                }
            } else {
                Log.e(TAG, "TextToSpeech：Initialization failed");
            }
        });
    }

    private void speak(String text) {
        mTextToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, text);
    }

    class TtsProgress extends UtteranceProgressListener {

        @Override
        public void onStart(String utteranceId) {
            Log.i(TAG, "TtsProgress：onStart " + utteranceId);
        }

        @Override
        public void onDone(String utteranceId) {
            Log.i(TAG, "TtsProgress：onDone " + utteranceId);
            if (utteranceId.equals(mLearnData.getZhName())) {
                speak(mLearnData.getEnName());
            }
        }

        @Override
        public void onError(String utteranceId) {
            Log.e(TAG, "TtsProgress：onError " + utteranceId);
        }
    }

    @Override
    protected void onDestroy() {
        // 停止当前正在播放的语音
        mTextToSpeech.stop();
        // 释放资源
        mTextToSpeech.shutdown();
        super.onDestroy();
    }
}