package com.learn.chinese.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.learn.chinese.R;
import com.learn.chinese.base.BaseFragment;
import com.learn.chinese.bean.LearnData;
import com.learn.chinese.data.LearnDataFactory;
import com.learn.chinese.design.mode.observer.ObservableImpl;
import com.learn.chinese.room.RoomManager;
import com.learn.chinese.view.ProgressBar;

import java.util.List;

public class AwardFragment extends BaseFragment {

    private ImageView imgStar1;
    private ImageView imgStar2;
    private ImageView imgStar3;
    private ProgressBar progressBar;
    private TextView textProgress;

    private ImageView imgDiamond1;
    private ImageView imgDiamond2;
    private ImageView imgDiamond3;
    private ProgressBar progressBarDiamond;
    private TextView textProgressDiamond;

    private int starNum = 0;
    private int diamondNum = 0;

    public static AwardFragment newInstance() {
        AwardFragment fragment = new AwardFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加观察者
        ObservableImpl.getInstance().addObserver(this, "test");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_award, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        imgStar1 = view.findViewById(R.id.img_star1);
        imgStar2 = view.findViewById(R.id.img_star2);
        imgStar3 = view.findViewById(R.id.img_star3);
        progressBar = view.findViewById(R.id.progress_bar);
        textProgress = view.findViewById(R.id.text_progress);

        imgDiamond1 = view.findViewById(R.id.img_diamond1);
        imgDiamond2 = view.findViewById(R.id.img_diamond2);
        imgDiamond3 = view.findViewById(R.id.img_diamond3);
        progressBarDiamond = view.findViewById(R.id.progress_bar_diamond);
        textProgressDiamond = view.findViewById(R.id.text_progress_diamond);
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        List<LearnData> learnDataList = LearnDataFactory.makeLearnData(0);
        RoomManager.checkDb(learnDataList, data -> {
            int star = 0;
            int diamond = 0;
            for (LearnData learnData : data) {
                star += learnData.getStar();
                diamond += learnData.getDiamond();
            }
            starNum = star;
            diamondNum = diamond;
            if (starNum < 3) {
                progressBar.setProgress(starNum * 100 / 3);
                textProgress.setText("Star " + starNum + "/3");
            } else if (starNum < 6) {
                progressBar.setProgress(starNum * 100 / 6);
                textProgress.setText("Star " + starNum + "/6");
                imgStar1.setImageResource(R.drawable.ic_medal_stars_1);
            } else {
                if (starNum < 9) {
                    progressBar.setProgress(starNum * 100 / 9);
                    textProgress.setText("Star " + starNum + "/9");
                    imgStar1.setImageResource(R.drawable.ic_medal_stars_1);
                    imgStar2.setImageResource(R.drawable.ic_medal_stars_2);
                } else {
                    progressBar.setProgress(100);
                    textProgress.setText("Star 9" + "/9");
                    imgStar1.setImageResource(R.drawable.ic_medal_stars_1);
                    imgStar2.setImageResource(R.drawable.ic_medal_stars_2);
                    imgStar3.setImageResource(R.drawable.ic_crown_stars);
                }
            }

            if (diamondNum < 3) {
                progressBarDiamond.setProgress(diamondNum * 100 / 3);
                textProgressDiamond.setText("Star " + diamondNum + "/3");
            } else if (diamondNum < 6) {
                progressBarDiamond.setProgress(starNum * 100 / 6);
                textProgressDiamond.setText("Star " + diamondNum + "/6");
                imgDiamond1.setImageResource(R.drawable.ic_medal_category_1);
            } else {
                if (diamondNum < 9) {
                    progressBarDiamond.setProgress(diamondNum * 100 / 9);
                    textProgressDiamond.setText("Diamond " + diamondNum + "/9");
                    imgDiamond1.setImageResource(R.drawable.ic_medal_category_1);
                    imgDiamond2.setImageResource(R.drawable.ic_medal_category_2);
                } else {
                    progressBarDiamond.setProgress(100);
                    textProgressDiamond.setText("Star 9" + "/9");
                    imgDiamond1.setImageResource(R.drawable.ic_medal_category_1);
                    imgDiamond2.setImageResource(R.drawable.ic_medal_category_2);
                    imgDiamond3.setImageResource(R.drawable.ic_crown_category);
                }
            }
        });
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