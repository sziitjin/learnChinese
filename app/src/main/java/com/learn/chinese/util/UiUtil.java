package com.learn.chinese.util;

import android.widget.ImageView;
import android.widget.TextView;

import com.learn.chinese.R;
import com.learn.chinese.bean.LearnData;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/6  11:25
 */
public class UiUtil {
    public static void setTextColor(TextView textView, int type) {
        int num = type % 10;
        switch (num) {
            case 0:
                textView.setTextColor(textView.getContext().getColor(R.color.item0_color));
                break;
            case 1:
                textView.setTextColor(textView.getContext().getColor(R.color.item1_color));
                break;
            case 2:
                textView.setTextColor(textView.getContext().getColor(R.color.item2_color));
                break;
            case 3:
                textView.setTextColor(textView.getContext().getColor(R.color.item3_color));
                break;
            case 4:
                textView.setTextColor(textView.getContext().getColor(R.color.item4_color));
                break;
            case 5:
                textView.setTextColor(textView.getContext().getColor(R.color.item5_color));
                break;
            case 6:
                textView.setTextColor(textView.getContext().getColor(R.color.item6_color));
                break;
            case 7:
                textView.setTextColor(textView.getContext().getColor(R.color.item7_color));
                break;
            case 8:
                textView.setTextColor(textView.getContext().getColor(R.color.item8_color));
                break;
            case 9:
                textView.setTextColor(textView.getContext().getColor(R.color.item9_color));
                break;
        }
    }

    public static void setImageResource(ImageView ivIcon, LearnData learnData) {
        if (learnData.getDiamond() == 1) {
            ivIcon.setImageResource(learnData.getIcon4());
        } else if (learnData.getStar() >= 3) {
            ivIcon.setImageResource(learnData.getIcon3());
        } else if (learnData.getStar() == 2) {
            ivIcon.setImageResource(learnData.getIcon2());
        } else if (learnData.getStar() == 1) {
            ivIcon.setImageResource(learnData.getIcon1());
        } else {
            ivIcon.setImageResource(learnData.getIcon());
        }
    }
}
