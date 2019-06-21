package com.example.xiangdada.test.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangpengfei on 2018/1/19.
 */

public abstract class AbstractAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mDatas;

    public AbstractAdapter(Context context, List<T> datas) {
        this.mContext = context;
        if (datas == null) {
            this.mDatas = new ArrayList<>();
        } else {
            this.mDatas = datas;
        }
    }

    public void notifyDataSetChanged(List<T> datas) {
        if (datas == null) {
            this.mDatas = new ArrayList<>();
        } else {
            this.mDatas = datas;
        }
        notifyDataSetChanged();
    }

    public List<T> getDatas() {
        return mDatas;
    }

    protected abstract AbstractViewHolder onCreateViewHolder(ViewGroup parent);

    protected abstract void onBindViewHolder(AbstractViewHolder abstractViewHolder, int position, T data);

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AbstractViewHolder abstractViewHolder = null;
        if (convertView == null) {
            abstractViewHolder = onCreateViewHolder(parent);
            convertView = abstractViewHolder.getView();
            convertView.setTag(abstractViewHolder);
        } else {
            abstractViewHolder = (AbstractViewHolder) convertView.getTag();
        }
        onBindViewHolder(abstractViewHolder, position, mDatas.get(position));
        return convertView;
    }

    public static class AbstractViewHolder {
        private View view;

        public AbstractViewHolder(View view) {
            this.view = view;
        }

        public View getView() {
            return view;
        }

    }


}
