package com.example.xiangdada.test.handler;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.xiangdada.test.R;

/**
 * Created by xdd on 2019/3/10
 */
public class HandlerActivity extends AppCompatActivity {
    private static final String URL = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1552211588240&di=64f79df16e142373746514542fd0d5f7&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201503%2F07%2F20150307190350_wH5jR.thumb.700_0.jpeg";
    private HandlerThread handlerThread;
    private Handler handler;
    private MyAsyncQueryHandler asyncQueryHandler;
    private ProgressBar progressbar;
    private ImageView imageview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        progressbar = findViewById(R.id.progressbar);
        imageview = findViewById(R.id.imageview);
        handlerThread();
        asyncQueryHandler();
        intentService();
        asyncTask();
    }

    private void handlerThread() {
        handlerThread = new HandlerThread("HandlerThread");
        handlerThread.start();

        handler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.i("测试", "HandlerThread>Message>what" + msg.what);
            }
        };
        handler.sendEmptyMessage(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(2);
            }
        }).start();
    }

    private void asyncQueryHandler() {
        final Uri uri = Uri.parse("content://com.android.contacts/data/phones");
        final String[] projection = {"_id", "display_name", "data1", "sort_key"};
        asyncQueryHandler = new MyAsyncQueryHandler(getContentResolver());
        asyncQueryHandler.startQuery(0, null, uri, projection,
                null, null, "sort_key COLLATE LOCALIZED asc");
    }

    private void intentService() {
        Intent serviceIntent = new Intent(this, MyIntentService.class);
        startService(serviceIntent);
    }

    private void asyncTask(){
        new MyAsyncTask(progressbar,imageview).execute(URL);
    }


}
