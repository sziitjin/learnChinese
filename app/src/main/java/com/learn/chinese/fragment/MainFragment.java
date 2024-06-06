package com.learn.chinese.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.chinese.LearnItemActivity;
import com.learn.chinese.R;
import com.learn.chinese.adapter.LearnGridAdapter;
import com.learn.chinese.base.BaseFragment;
import com.learn.chinese.bean.LearnData;
import com.learn.chinese.data.LearnDataFactory;
import com.learn.chinese.design.mode.observer.ObservableImpl;
import com.learn.chinese.design.mode.observer.Observer;
import com.learn.chinese.room.RoomManager;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainFragment extends BaseFragment{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private LearnGridAdapter gridAdapter;

    public MainFragment() {
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        // 添加观察者
        ObservableImpl.getInstance().addObserver(this, "test");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        int count = recyclerView.getItemDecorationCount();
        for (int i = 0; i < count; i++) {
            recyclerView.removeItemDecorationAt(i);
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        gridAdapter = new LearnGridAdapter(mContext);
        recyclerView.setAdapter(gridAdapter);
        gridAdapter.setOnItemClickListener(learnData -> {
            Intent intent = new Intent(mContext, LearnItemActivity.class);
            intent.putExtra("zhName", learnData.getZhName());
            intent.putExtra("enName", learnData.getEnName());
            intent.putExtra("type", learnData.getType());
            startActivity(intent);
        });
    }

    private void initData() {
        List<LearnData> learnDataList = LearnDataFactory.makeLearnData(0);
        RoomManager.checkDb(learnDataList, data -> {
            gridAdapter.setData(data);
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