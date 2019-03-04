package com.example.xiangdada.test.dagger2.qualifier;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by xdd on 2019/3/3
 */
public class Qualifier {
//    @Named("context")
    @Person2WithContext
    @Inject
    Person2 person2Context;
//    @Named("string")
    @Person2WithName
    @Inject
    Person2 person2String;

    public Qualifier(Context context){
        DaggerPerson2Component
                .builder()
                .person2Module(new Person2Module(context,"name"))
                .build()
                .inject(this);
    }

    public void qualifier(){
        Log.i("测试","@Qualifier注解和@Named注解的用法以及作用是一样的");
    }
}
