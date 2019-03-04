package com.example.xiangdada.test.designpattern.observer;

import java.util.Vector;

/**
 * Created by xdd on 2019/2/17
 * 气象站
 */
public class Meteoric implements Subject {
    private String weather;
    private Vector tvs;

    public Meteoric(){
        weather = "";
        tvs = new Vector();
    }

    @Override
    public void add(Observer observer) {
        tvs.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        tvs.remove(observer);
    }

    @Override
    public void notice() {
        for (int i = 0; i < tvs.size(); i++) {
            ((Observer)tvs.get(i)).update();
        }
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
        notice();
    }
}
