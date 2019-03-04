package com.example.xiangdada.test.designpattern.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xdd on 2019/2/18
 *
 * 事物处理类
 */
public class ProxyHandle implements InvocationHandler {
    private Object target;

    public Object create(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.i("测试","--------------ProxyHandle开始---------------");
        Object value = method.invoke(target,args);
        Log.i("测试","--------------ProxyHandle开始---------------");
        return value;
    }
}
