package com.example.xiangdada.test.designpattern.decorrator;

import android.util.Log;

/**
 * Created by xdd on 2019/2/17
 * 具体被装饰对象,定义一个对象，可以给这个对象添加一些职责
 * 即一般情况下泡牛奶喝的步骤
 */
public class ConcreteComponent implements Component {
    @Override
    public void water() {
        Log.i("测试","加热水");
    }

    @Override
    public void milk() {
        Log.i("测试","加奶粉");
    }

    @Override
    public void drink() {
        Log.i("测试","喝牛奶");
    }

    @Override
    public void process() {
        water();
        milk();
        drink();
    }
}
