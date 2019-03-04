package com.example.xiangdada.test.dagger2.two;

import javax.inject.Inject;

/**
 * Created by xdd on 2019/3/3
 */
public class Teacher2 {
    @Inject
    Student2 student2;

    public Teacher2(){
        DaggerTeacherComponent2.builder().teacher2Module(new Teacher2Module()).build().inject(this);
    }

    public void teacher(){
        student2.startLessons();
    }
}
