package com.example.xiangdada.test.handler;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by xdd on 2019/3/10
 */
public class ServiceActivity extends AppCompatActivity {
    private String method = "";
    private Intent startIntent;
    private Intent bindIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getIntentParams();
        service();
    }

    private void getIntentParams() {
        method = getIntent().getStringExtra("method");
    }

    private void service() {
        if ("startService".equals(method)) {
            startService();
        } else if ("bindService".equals(method)) {
            bindService();
        }
    }

    private void startService() {
        startIntent = new Intent(this, MyService.class);
        startService(startIntent);
    }

    private void bindService() {
        bindIntent = new Intent(this, MyService.class);
        bindService(bindIntent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder myBinder = (MyService.MyBinder) service;
            myBinder.action();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if ("startService".equals(method)) {
            stopService(startIntent);
        } else if ("bindService".equals(method)) {
            unbindService(serviceConnection);
        }
    }
}
