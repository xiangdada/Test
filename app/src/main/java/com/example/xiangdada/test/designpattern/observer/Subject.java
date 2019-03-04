package com.example.xiangdada.test.designpattern.observer;

/**
 * Created by xdd on 2019/2/17
 *
 * 被观察者，可以有多个观察者，当发生变化时通知观察者更新
 */
public interface Subject {
    public void add(Observer observer);

    public void remove(Observer observer);

    public void notice();

}
