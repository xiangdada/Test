package com.example.xiangdada.test.dagger2.qualifier;

import android.content.Context;
import android.util.Log;

/**
 * Created by xdd on 2019/3/3
 */
public class Person2 {
    private Context context;
    private String name;

    public Person2(Context context){
        this.context =context;
        Log.i("测试","Context作为参数的构造函数");
    }

    public Person2(String name){
        this.name = name;
        Log.i("测试","String作为参数的构造函数");
    }
}
