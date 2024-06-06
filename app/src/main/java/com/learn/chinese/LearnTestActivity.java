package com.learn.chinese;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.learn.chinese.bean.LearnData;
import com.learn.chinese.data.LearnDataFactory;
import com.learn.chinese.design.mode.observer.ObservableImpl;
import com.learn.chinese.room.RoomManager;
import com.learn.chinese.util.UiUtil;
import com.learn.chinese.view.ProgressBar;
import com.lib.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class LearnTestActivity extends BaseActivity {
    private static final String TAG = "LearnTestActivity";
    private ProgressBar progressBar;
    private TextView textProgress;

    private TextView tvZhName;
    private TextView tvEnName;

    private ImageView ivItem1, ivItem2;
    private ImageView ivRight;

    private List<LearnData> learnDataList;
    private LearnData resultData;
    private int randomNum = 0;
    private int resultIndex = 0;
    private LearnData testData;
    private int process = 0;

    private TextToSpeech mTextToSpeech;
    private Animation zoomInAnimation;

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_learn_test);
        initView();
        initData();
        initTest();
    }

    private void initView() {
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setProgress(process);
        textProgress = findViewById(R.id.text_progress);

        tvZhName = findViewById(R.id.tv_zh_name);
        tvEnName = findViewById(R.id.tv_en_name);
        ivItem1 = findViewById(R.id.iv_item1);
        ivItem2 = findViewById(R.id.iv_item2);
        ivRight = findViewById(R.id.iv_right);

        zoomInAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        zoomInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // 动画开始时的操作，如果不需要可以为空
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // 动画结束时的操作
                ivRight.clearAnimation();
                ivRight.setVisibility(View.GONE); // 隐藏 ImageView
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // 动画重复时的操作，如果不需要可以为空
            }
        });
    }

    private void initData() {
        mHandler = new Handler();
        String zhName = getIntent().getStringExtra("zhName");
        String enName = getIntent().getStringExtra("enName");
        setActivityTitle(zhName + "（" + enName + "）");
        int type = getIntent().getIntExtra("type", 0);
        UiUtil.setTextColor(tvZhName, type);
        learnDataList = LearnDataFactory.makeLearnData(type);

        mTextToSpeech = new TextToSpeech(mContext, status -> {
            if (status == TextToSpeech.SUCCESS) {
                mTextToSpeech.setOnUtteranceProgressListener(new TtsProgress());
                // 设置音调，1.0是常规（范围0.5到2.0）
                mTextToSpeech.setPitch(1.0f);
                // 设定语速，默认1.0正常语速（范围为0.1到2.0）
                mTextToSpeech.setSpeechRate(0.8f);
                speak(resultData.getZhName());
                int result = mTextToSpeech.setLanguage(Locale.getDefault());
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e(TAG, "TextToSpeech：This language is not supported");
                }
            } else {
                Log.e(TAG, "TextToSpeech：Initialization failed");
            }
        });
    }

    private void initTest() {
        randomNum = getRandom(learnDataList.size());
        resultData = learnDataList.get(randomNum);

        int randomTest = getRandom(learnDataList.size(), randomNum);
        testData = learnDataList.get(randomTest);

        tvZhName.setText(resultData.getZhName());
        tvEnName.setText(resultData.getEnName());
        speak(resultData.getZhName());

        List<LearnData> testDatas = new ArrayList<>();
        testDatas.add(testData);
        resultIndex = getRandom(2);
        testDatas.add(resultIndex, resultData);
        ivItem1.setImageResource(testDatas.get(0).getIcon());
        ivItem2.setImageResource(testDatas.get(1).getIcon());
    }

    public int getRandom(int num) {
        Random rand = new Random();
        return rand.nextInt(num);
    }

    public int getRandom(int num, int result) {
        Random rand = new Random();
        int randomNum = 0;
        do {
            randomNum = rand.nextInt(num);
        } while (randomNum == result);
        return randomNum;
    }


    public void toPlay(View view) {
        speak(resultData.getZhName());
    }

    private void speak(String text) {
        mTextToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, text);
    }

    public void clickItem1(View view) {
        if (resultIndex == 0) {
            toRight();
        } else {
            speak("错了");
        }
    }

    public void clickItem2(View view) {
        if (resultIndex == 1) {
            toRight();
        } else {
            speak("错了");
        }
    }

    private void toRight() {
        process += 10;
        progressBar.setProgress(process);
        textProgress.setText(process / 10 + "/10");
        speak("对了");
        ivRight.setVisibility(View.VISIBLE);
        ivRight.startAnimation(zoomInAnimation);
        mHandler.postDelayed(() -> {
            if (process != 100) {
                initTest();
            } else {
                RoomManager.updateStarAndDiamond(resultData.getType(), data -> {
                    // 通知观察者
                    ObservableImpl.getInstance().notifyObserver(data, "test");
                    finish();
                });
            }
        }, 2100);
    }

    class TtsProgress extends UtteranceProgressListener {

        @Override
        public void onStart(String utteranceId) {
            Log.i(TAG, "TtsProgress：onStart " + utteranceId);
        }

        @Override
        public void onDone(String utteranceId) {
            Log.i(TAG, "TtsProgress：onDone " + utteranceId);
            if (utteranceId.equals(resultData.getZhName())) {
                speak(resultData.getEnName());
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
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
            mHandler = null;
        }
    }
}