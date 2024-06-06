package com.learn.chinese;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.learn.chinese.view.ProgressBar;
import com.lib.base.BaseActivity;

public class AwardActivity extends BaseActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_award);
        initView();
        initData();
    }

    private void initView() {
        imgStar1 = findViewById(R.id.img_star1);
        imgStar2 = findViewById(R.id.img_star2);
        imgStar3 = findViewById(R.id.img_star3);
        progressBar = findViewById(R.id.progress_bar);
        textProgress = findViewById(R.id.text_progress);

        imgDiamond1 = findViewById(R.id.img_diamond1);
        imgDiamond2 = findViewById(R.id.img_diamond2);
        imgDiamond3 = findViewById(R.id.img_diamond3);
        progressBarDiamond = findViewById(R.id.progress_bar_diamond);
        textProgressDiamond = findViewById(R.id.text_progress_diamond);
    }

    private void initData() {
        setActivityTitle("奖杯（Award）");
        starNum = getIntent().getIntExtra("starNum", 0);
        diamondNum = getIntent().getIntExtra("diamondNum", 0);

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
    }
}