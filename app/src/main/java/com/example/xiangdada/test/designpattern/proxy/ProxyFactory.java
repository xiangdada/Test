package com.example.xiangdada.test.designpattern.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by xdd on 2019/2/18
 *
 * 动态代理工厂
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object create(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Log.i("测试","--------------ProxyFactory开始---------------");
                Object value = method.invoke(target,args);
                Log.i("测试","--------------ProxyFactory完成---------------");
                return value;
            }
        });
    }

}
