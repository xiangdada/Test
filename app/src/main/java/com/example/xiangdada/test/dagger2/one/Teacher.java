package com.example.xiangdada.test.dagger2.one;


import javax.inject.Inject;

/**
 * Created by xdd on 2019/3/3
 */
public class Teacher {
    @Inject
    Student student;

    public Teacher(){
        DaggerTeacherComponent.builder().build().inject(this);
    }

    public void teacher(){
        student.startLessons();
    }
}
