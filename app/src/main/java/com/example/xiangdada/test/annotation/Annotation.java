package com.example.xiangdada.test.annotation;

import android.util.Log;

/**
 * Created by xiangpengfei on 2019/2/19.
 */
public class Annotation {
    @BindAddress()
    String address;

    @BindPort()
    private String port;

    @BindAddress("http://www.google.com.cn")
    String address1;

    @BindPort("8888")
    String port1;

    public void log() {
        Log.i("测试", "address = " + address + ",port = " + port + ",address1 = " + address1 + ",port1 = " + port1);
    }

    @BindGet("mike")
    void getHttp(String params) {
        Log.i("测试", params);
    }
}
