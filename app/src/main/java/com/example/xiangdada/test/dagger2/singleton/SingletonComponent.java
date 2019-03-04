package com.example.xiangdada.test.dagger2.singleton;

import dagger.Component;

/**
 * Created by xdd on 2019/3/3
 */
@javax.inject.Singleton
@Component(modules =  SingletonModule.class)
public interface SingletonComponent {
    void inject(Singleton singleton);
}
