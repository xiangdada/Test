package com.example.xiangdada.test.designpattern.decorrator;

import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by xdd on 2019/2/17
 */
public class SugarDecorator extends Decorator {

    public SugarDecorator(@NonNull Component component) {
        super(component);
    }

    public void sugar(){
        Log.i("测试","加点糖");
    }

    @Override
    public void milk() {
        super.milk();
        sugar();
    }
}
