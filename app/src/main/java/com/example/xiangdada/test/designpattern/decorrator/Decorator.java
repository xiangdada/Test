package com.example.xiangdada.test.designpattern.decorrator;

import android.support.annotation.NonNull;

/**
 * Created by xdd on 2019/2/17
 * 装饰者抽象类
 * 维持一个指向Component实例的引用，并定义一个与Component接口一致的接口
 */
public abstract class Decorator implements Component {
    protected Component component;

    public Decorator(@NonNull Component component){
        this.component = component;
    }

    @Override
    public void water() {
        component.water();
    }

    @Override
    public void milk() {
        component.milk();
    }

    @Override
    public void drink() {
        component.drink();
    }

    @Override
    public void process() {
        water();
        milk();
        drink();
    }
}
