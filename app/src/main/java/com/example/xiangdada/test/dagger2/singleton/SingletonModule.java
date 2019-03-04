package com.example.xiangdada.test.dagger2.singleton;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xdd on 2019/3/3
 */
@Module
public class SingletonModule {

    @Singleton
    @Provides
    Person providesPerson(){
        return new Person();
    }
}
