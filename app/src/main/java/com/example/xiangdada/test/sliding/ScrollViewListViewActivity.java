package com.example.xiangdada.test.sliding;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import com.example.xiangdada.test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangpengfei on 2019/6/21.
 */
public class ScrollViewListViewActivity extends Activity {
    private ListView listview;
    List<ListData> datas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scollview_listview);
        findViewById();
        addListener();
        initData();
        initListView();
    }

    private void findViewById() {
        listview = findViewById(R.id.listview);
    }


    private void addListener() {
        listview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("测试","TestListView--onTouch");
//                listview.getParent().getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }

    private void initData() {
        datas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            datas.add(new ListData(R.mipmap.ic_launcher, "标题" + i, "AAAAAAAAAAAAAAAAAAA"));
        }
    }

    private void initListView() {
        ListAdaptere adaptere = new ListAdaptere(this, datas);
        listview.setAdapter(adaptere);
    }


}
