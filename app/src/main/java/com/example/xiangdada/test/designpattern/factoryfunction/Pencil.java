package com.example.xiangdada.test.designpattern.factoryfunction;

import android.util.Log;

/**
 * Created by xdd on 2019/2/17
 */
public class Pencil implements Product {
    @Override
    public void action() {
        Log.i("测试","铅笔");
    }
}
