package com.example.xiangdada.test.dagger2.two;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by xdd on 2019/3/3
 */
public class Book {
    private String name;

    public Book() {
//        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void remark(){
        Log.i("测试","在书本上做笔记");
    }
}
