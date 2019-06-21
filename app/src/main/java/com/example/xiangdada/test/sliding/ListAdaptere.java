package com.example.xiangdada.test.sliding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiangdada.test.R;
import com.example.xiangdada.test.adapter.AbstractAdapter;

import java.util.List;

/**
 * Created by xiangpengfei on 2019/6/21.
 */
public class ListAdaptere extends AbstractAdapter<ListData> {

    public ListAdaptere(Context context, List<ListData> datas) {
        super(context, datas);
    }

    @Override
    protected AbstractViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_list, parent, false));
    }

    @Override
    protected void onBindViewHolder(AbstractViewHolder abstractViewHolder, int position, ListData data) {
        ViewHolder holder = (ViewHolder) abstractViewHolder;
        if (holder == null || data == null) {
            return;
        }
        holder.ivPicture.setImageResource(data.getDrawabRes());
        holder.tvTitle.setText(data.getTitle());
        holder.tvContent.setText(data.getConetnt());
    }

    private static class ViewHolder extends AbstractViewHolder {
        ImageView ivPicture;
        TextView tvTitle;
        TextView tvContent;

        public ViewHolder(View view) {
            super(view);
            ivPicture = view.findViewById(R.id.ivPicture);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvContent = view.findViewById(R.id.tvContent);
        }
    }

}
