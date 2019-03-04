package com.example.xiangdada.test.dagger2.two;

import dagger.Component;

/**
 * Created by xdd on 2019/3/3
 */
@Component(modules = Teacher2Module.class)
public interface TeacherComponent2 {
    void inject(Teacher2 teacher2);
}
