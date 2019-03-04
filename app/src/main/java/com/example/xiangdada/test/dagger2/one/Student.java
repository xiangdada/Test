package com.example.xiangdada.test.dagger2.one;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by xdd on 2019/3/3
 */
public class Student {
    private int id;
    private String name;
    private String[] course;

    @Inject
    public Student() {
        Log.i("测试","无参构造方法创建Student");
    }

    public Student(int id, String name, String[] course) {
        this.id = id;
        this.name = name;
        this.course = course;
        Log.i("测试","有参构造方法创建Student");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCourse() {
        return course;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }

    public void startLessons(){
        Log.i("测试","开始上课了！");
    }
}
