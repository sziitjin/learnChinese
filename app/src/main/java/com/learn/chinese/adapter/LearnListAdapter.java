package com.learn.chinese.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.chinese.R;
import com.learn.chinese.bean.LearnData;
import com.learn.chinese.util.UiUtil;

import java.util.List;

/**
 * Created by BINGO
 * 2021/4/20
 */
public class LearnListAdapter extends RecyclerView.Adapter<LearnListAdapter.ViewHolder> {

    private Context context;
    private List<LearnData> learnDataList;
    private OnLearnItemClickListener mOnItemClickLitener;


    public LearnListAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<LearnData> learnDataList) {
        this.learnDataList = learnDataList;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnLearnItemClickListener listener) {
        mOnItemClickLitener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == 15 || viewType == 16 || viewType == 17) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_long, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_control, parent, false);
        }
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LearnData learnData = learnDataList.get(position);
        setLearnItem(holder, learnData);
    }

    @Override
    public int getItemCount() {
        return learnDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return learnDataList.get(position).getType();
    }

    private void setLearnItem(ViewHolder holder, LearnData learnData) {
        holder.tvZhName.setText(learnData.getZhName());
        UiUtil.setTextColor(holder.tvZhName, learnData.getType());
        holder.tvEnName.setText(learnData.getEnName());
        holder.ivIcon.setImageResource(learnData.getIcon());
        holder.itemView.setOnClickListener(v -> {
            if (mOnItemClickLitener != null) {
                mOnItemClickLitener.onItemClick(learnData);
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivIcon;
        private TextView tvZhName;
        private TextView tvEnName;

        public ViewHolder(View view) {
            super(view);
            ivIcon = view.findViewById(R.id.iv_icon);
            tvZhName = view.findViewById(R.id.tv_zh_name);
            tvEnName = view.findViewById(R.id.tv_en_name);
        }
    }

    public interface OnLearnItemClickListener {
        void onItemClick(LearnData learnData);
    }
}