package com.example.xiangdada.test.dagger2.two;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xdd on 2019/3/3
 */
@Module
public class Teacher2Module {

    @Provides
    Book provideBook(){
        return new Book();
    }
}
