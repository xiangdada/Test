package com.example.xiangdada.test.handler;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * Created by xdd on 2019/3/10
 */
public class MyIntentService extends IntentService {
    public MyIntentService() {
        super(MyIntentService.class.getName());
    }

    @Override
    protected void onHandleIntent(@NonNull Intent intent) {
        // 这个方法是在后台调用，在这里实现具体的后台业务逻辑
    }
}
