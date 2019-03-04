package com.example.xiangdada.test.designpattern.decorrator;

import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by xdd on 2019/2/17
 */
public class HoneyDecorator extends Decorator {
    public HoneyDecorator(@NonNull Component component) {
        super(component);
    }

    public void honey(){
        Log.i("测试","加蜂蜜");
    }

    @Override
    public void milk() {
        super.milk();
        honey();
    }
}
