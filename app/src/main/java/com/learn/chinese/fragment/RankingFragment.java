package com.learn.chinese.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.chinese.LearnTestActivity;
import com.learn.chinese.R;
import com.learn.chinese.adapter.LearnGridAdapter;
import com.learn.chinese.adapter.RankingAdapter;
import com.learn.chinese.base.BaseFragment;
import com.learn.chinese.bean.RankingBean;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RankingFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private RankingAdapter listAdapter;

    public static RankingFragment newInstance() {
        RankingFragment fragment = new RankingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ranking, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 1));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        listAdapter = new RankingAdapter(mContext);
        recyclerView.setAdapter(listAdapter);
    }

    private void initData() {
        List<RankingBean> rankingList = new ArrayList<>();
        rankingList.add(new RankingBean("Suk", R.drawable.aquatic, 99, 99, 1));
        rankingList.add(new RankingBean("LiangJinQing", R.drawable.flowers, 90, 98, 2));
        rankingList.add(new RankingBean("Rui", R.drawable.vegetables, 95, 90, 3));
        rankingList.add(new RankingBean("Chen", R.drawable.vegetables_2, 80, 85, 4));
        listAdapter.setData(rankingList);
    }
}