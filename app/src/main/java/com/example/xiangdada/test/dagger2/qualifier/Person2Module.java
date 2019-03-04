package com.example.xiangdada.test.dagger2.qualifier;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xdd on 2019/3/3
 */
@Module
public class Person2Module {
    private Context context;
    private String name;

    public Person2Module(Context context,String name){
        this.context =context;
        this.name =name;
    }

    @Provides
    public Context providesContext(){
        return context;
    }

    @Provides
    public String providesName(){
        return name;
    }

//    @Named("context")
    @Person2WithContext
    @Provides
    public Person2 providesPerson2WithContext(Context context){
        return new Person2(context);
    }

//    @Named("string")
    @Person2WithName
    @Provides
    public Person2 providesPerson2WithName(String name){
        return new Person2(name);
    }

}
