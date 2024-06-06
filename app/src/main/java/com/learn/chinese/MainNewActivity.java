package com.learn.chinese;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.learn.chinese.adapter.ViewPager2Adapter;
import com.learn.chinese.bean.LearnData;
import com.learn.chinese.data.LearnDataFactory;
import com.learn.chinese.design.mode.observer.ObservableImpl;
import com.learn.chinese.design.mode.observer.Observer;
import com.learn.chinese.fragment.AwardFragment;
import com.learn.chinese.fragment.MainFragment;
import com.learn.chinese.fragment.RankingFragment;
import com.learn.chinese.fragment.SettingFragment;
import com.learn.chinese.fragment.TestFragment;
import com.learn.chinese.room.RoomManager;
import com.lib.base.util.StatusBar;

import java.util.ArrayList;
import java.util.List;

public class MainNewActivity extends AppCompatActivity implements Observer {
    private static final String TAG = "MainNewActivity";
    private TextView textStar;
    private TextView textDiamond;
    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        StatusBar.fullScreen(this, false);
        StatusBar.setAndroidNativeLightStatusBar(this, false);
        // 添加观察者
        ObservableImpl.getInstance().addObserver(this, "test");
        initView();
        initData();
    }

    private void initView() {
        textStar = findViewById(R.id.text_star);
        textDiamond = findViewById(R.id.text_diamond);

        viewPager2 = findViewById(R.id.view_pager2);
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this, initFragments());
        viewPager2.setAdapter(viewPager2Adapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.menu_home);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.menu_test);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.menu_award);
                        break;
                    case 3:
                        bottomNavigationView.setSelectedItemId(R.id.menu_ranking);
                        break;
                    case 4:
                        bottomNavigationView.setSelectedItemId(R.id.menu_set);
                        break;
                }
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_home:
                    viewPager2.setCurrentItem(0);
                    break;
                case R.id.menu_test:
                    viewPager2.setCurrentItem(1);
                    break;
                case R.id.menu_award:
                    viewPager2.setCurrentItem(2);
                    break;
                case R.id.menu_ranking:
                    viewPager2.setCurrentItem(3);
                    break;
                case R.id.menu_set:
                    viewPager2.setCurrentItem(4);
                    break;
            }
            return true;
        });
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
            Log.i(TAG, "initData star:" + star + ",diamond:" + diamond);
            textStar.setText(String.valueOf(star));
            textDiamond.setText(String.valueOf(diamond));
        });
    }

    private List<Fragment> initFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(MainFragment.newInstance("", ""));
        fragments.add(TestFragment.newInstance("", ""));
        fragments.add(AwardFragment.newInstance());
        fragments.add(RankingFragment.newInstance());
        fragments.add(SettingFragment.newInstance());
        return fragments;
    }

    @Override
    public void update(String message) {
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ObservableImpl.getInstance().removeObserver(this);
    }
}