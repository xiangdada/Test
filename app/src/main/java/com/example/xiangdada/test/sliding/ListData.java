package com.example.xiangdada.test.sliding;

import java.io.Serializable;

/**
 * Created by xiangpengfei on 2019/6/21.
 */
public class ListData implements Serializable {
    private int drawabRes;
    private String title;
    private String conetnt;

    public ListData(){

    }

    public ListData(int drawabRes, String title, String conetnt) {
        this.drawabRes = drawabRes;
        this.title = title;
        this.conetnt = conetnt;
    }

    public int getDrawabRes() {
        return drawabRes;
    }

    public void setDrawabRes(int drawabRes) {
        this.drawabRes = drawabRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConetnt() {
        return conetnt;
    }

    public void setConetnt(String conetnt) {
        this.conetnt = conetnt;
    }
}
