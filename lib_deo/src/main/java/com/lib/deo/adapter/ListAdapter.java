package com.lib.deo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lib.deo.R;

import java.util.List;

/**
 * Created by BINGO
 * 2021/4/20
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private Context context;
    private List<String> dataList;
    private OnItemClickListener mOnItemClickLitener;


    public ListAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<String> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickLitener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setLearnItem(holder, position);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private void setLearnItem(ViewHolder holder, int position) {
        holder.tvName.setText(dataList.get(position));
        holder.itemView.setOnClickListener(v -> {
            if (mOnItemClickLitener != null) {
                mOnItemClickLitener.onItemClick(position);
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        public ViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}