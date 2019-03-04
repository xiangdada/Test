package com.example.xiangdada.test.designpattern.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by xdd on 2019/2/18
 *
 * 事物处理类
 */
public class TransactionProxy implements InvocationHandler {
    private Object target;

    public TransactionProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.i("测试","--------------TransactionProxy开始---------------");
        Object value = method.invoke(target,args);
        Log.i("测试","--------------TransactionProxy开始---------------");
        return value;
    }
}
