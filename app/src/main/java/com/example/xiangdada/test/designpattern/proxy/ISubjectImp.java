package com.example.xiangdada.test.designpattern.proxy;

import android.util.Log;

/**
 * Created by xdd on 2019/2/18
 */
public class ISubjectImp implements ISubject {
    @Override
    public void action() {
        Log.i("测试","被代理类执行的方法");
    }
}
