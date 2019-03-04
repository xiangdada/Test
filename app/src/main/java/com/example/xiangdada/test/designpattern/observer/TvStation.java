package com.example.xiangdada.test.designpattern.observer;

import android.util.Log;

/**
 * Created by xdd on 2019/2/17
 */
public class TvStation implements Observer {
    private String weather;

    private String tvName;
    private Meteoric meteoric;

    public TvStation(String tvName, Meteoric meteoric) {
        this.tvName = tvName;
        this.meteoric = meteoric;
    }

    @Override
    public void update() {
        weather = meteoric.getWeather();
        Log.i("测试",weather);
    }

}
