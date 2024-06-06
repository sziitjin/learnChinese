package com.learn.chinese.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

/**
 * @Author: Jin
 * @Description:
 * @CreateDate: 2023/7/26  11:43
 */
public class ViewPager2Adapter extends FragmentStateAdapter {
    List<Fragment> fragmentList;

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> list) {
        super(fragmentActivity);
        this.fragmentList = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
