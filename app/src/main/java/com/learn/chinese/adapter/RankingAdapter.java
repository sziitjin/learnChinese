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
import com.learn.chinese.bean.RankingBean;
import com.learn.chinese.util.UiUtil;

import java.util.List;

/**
 * Created by BINGO
 * 2021/4/20
 */
public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {

    private Context context;
    private List<RankingBean> rankingList;

    public RankingAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<RankingBean> rankingList) {
        this.rankingList = rankingList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranking_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RankingBean data = rankingList.get(position);
        setItemData(holder, data);
    }

    @Override
    public int getItemCount() {
        return rankingList.size();
    }

    private void setItemData(ViewHolder holder, RankingBean data) {
        holder.textRanking.setText(String.valueOf(data.getRanking()));
        if (data.getRanking() == 1) {
            holder.textRanking.setTextColor(holder.textRanking.getContext().getColor(R.color.item3_color));
        } else if (data.getRanking() == 2) {
            holder.textRanking.setTextColor(holder.textRanking.getContext().getColor(R.color.item9_color));
        } else if (data.getRanking() == 3) {
            holder.textRanking.setTextColor(holder.textRanking.getContext().getColor(R.color.item6_color));
        } else {
            holder.textRanking.setTextColor(holder.textRanking.getContext().getColor(R.color.white));
        }
        holder.imgHead.setImageResource(data.getIcon());
        String text = data.getName();
        int len = text.length();
        if (len > 6) {
            text = text.substring(0, 2) + "**" + text.substring(len - 2, len);
        }
        holder.textName.setText(text);
        holder.textStar.setText(String.valueOf(data.getStar()));
        holder.textDiamond.setText(String.valueOf(data.getDiamond()));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textRanking;
        private ImageView imgHead;
        private TextView textName;
        private TextView textStar;
        private TextView textDiamond;

        public ViewHolder(View view) {
            super(view);
            textRanking = view.findViewById(R.id.text_ranking);
            imgHead = view.findViewById(R.id.img_head);
            textName = view.findViewById(R.id.text_name);
            textStar = view.findViewById(R.id.text_star);
            textDiamond = view.findViewById(R.id.text_diamond);
        }
    }
}