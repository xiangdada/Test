package com.example.xiangdada.test.dagger2.singleton;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by xdd on 2019/3/3
 *
 * 在SingletonModule的providesPerson()方法上以及SingletonComponent接口上
 * 加上@Singleton的注解，就可以使得同一个Singleton中的Person指向同一个对象。
 */
public class Singleton {
    @Inject
    Person person1;
    @Inject
    Person person2;

    public Singleton(){
        DaggerSingletonComponent
                .builder().
                singletonModule(new SingletonModule())
                .build()
                .inject(this);
    }

    public void person(){
        Log.i("测试","person1 = "+person1.toString());
        Log.i("测试","person2 = "+person2.toString());
    }

}
