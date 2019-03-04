package com.example.xiangdada.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.xiangdada.test.annotation.Annotation;
import com.example.xiangdada.test.annotation.BindAddress;
import com.example.xiangdada.test.annotation.BindGet;
import com.example.xiangdada.test.annotation.BindPort;
import com.example.xiangdada.test.dagger2.one.Teacher;
import com.example.xiangdada.test.dagger2.qualifier.Qualifier;
import com.example.xiangdada.test.dagger2.singleton.Singleton;
import com.example.xiangdada.test.dagger2.two.Teacher2;
import com.example.xiangdada.test.designpattern.decorrator.ConcreteComponent;
import com.example.xiangdada.test.designpattern.decorrator.HoneyDecorator;
import com.example.xiangdada.test.designpattern.decorrator.SugarDecorator;
import com.example.xiangdada.test.designpattern.factoryfunction.Test;
import com.example.xiangdada.test.designpattern.observer.Meteoric;
import com.example.xiangdada.test.designpattern.observer.TvStation;
import com.example.xiangdada.test.designpattern.proxy.ISubject;
import com.example.xiangdada.test.designpattern.proxy.ISubjectImp;
import com.example.xiangdada.test.designpattern.proxy.ProxyFactory;
import com.example.xiangdada.test.designpattern.proxy.ProxyHandle;
import com.example.xiangdada.test.designpattern.proxy.TransactionProxy;
import com.example.xiangdada.test.sort.Sort;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        factory();
        observer();
        decorrator();
        proxy();
        annotation();
        dagger2();
    }

    /**
     * 工厂模式测试
     */
    private void factory() {
        Test.createPen();
        Test.createPencil();
    }

    /**
     * 观察者模式测试
     */
    private void observer() {
        Meteoric meteoric = new Meteoric(); // 被观察的对象
        TvStation tvStation = new TvStation("cctv", meteoric);  // 订阅者
        meteoric.add(tvStation);
        meteoric.setWeather("下雨");
        meteoric.setWeather("天晴");
    }

    /**
     * 装饰着模式测试，在原本步骤中的 加奶粉 后面增加两个步骤 加点糖 加蜂蜜
     * honeyDecorator未重写的方法以及super.方法的调用，其实都是执行了sugarDecorator的同名方法，
     * 同理，sugarDecorator未重写的方法以及super.方法的调用，其实都是执行了concreteComponent的同名方法，
     */
    private void decorrator() {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        SugarDecorator sugarDecorator = new SugarDecorator(concreteComponent);
        HoneyDecorator honeyDecorator = new HoneyDecorator(sugarDecorator);
        honeyDecorator.process();
    }

    /**
     * 动态代理模式测试
     */
    private void proxy() {
        ISubjectImp iSubjectImp = new ISubjectImp();
        // 方式一
        TransactionProxy transactionProxy = new TransactionProxy(iSubjectImp);
        ISubject iSubject1 = (ISubject) Proxy.newProxyInstance(iSubjectImp.getClass().getClassLoader(), iSubjectImp.getClass().getInterfaces(), transactionProxy);
        iSubject1.action();
        // 方式二
        ProxyFactory proxyFactory = new ProxyFactory(iSubjectImp);
        ISubject iSubject2 = (ISubject) proxyFactory.create();
        iSubject2.action();
        // 方式三
        ProxyHandle proxyHandle = new ProxyHandle();
        ISubject iSubject3 = (ISubject) proxyHandle.create(iSubjectImp);
        iSubject3.action();
    }

    /**
     * 自定义注解测试
     * 注解是被动的元数据，需要使用反射来使得注解产生意义
     */
    private void annotation() {
        try {
            Class c = Class.forName("com.example.xiangdada.test.annotation.Annotation");
            Annotation annotation = (Annotation) c.newInstance();
            Field[] fields = c.getDeclaredFields(); // 获取所有属性
            for (Field field : fields) {
                if (field.isAnnotationPresent(BindPort.class)) {
                    BindPort port = field.getAnnotation(BindPort.class);
                    field.setAccessible(true);
                    field.set(annotation, port.value());
                }
                if (field.isAnnotationPresent(BindAddress.class)) {
                    BindAddress address = field.getAnnotation(BindAddress.class);
                    field.setAccessible(true);
                    field.set(annotation, address.value());
                }
            }
            annotation.log();

            Method[] methods = c.getDeclaredMethods();  // 获取所有方法
            for (Method method : methods) {
                if (method.isAnnotationPresent(BindGet.class)) {
                    BindGet get = method.getAnnotation(BindGet.class);
                    String params = get.value();
                    method.setAccessible(true);
                    method.invoke(annotation, params);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 排序方法测试
     */
    private void sort(){
        int[] bubble = Sort.bubble(getArrays());
        Log.i("测试",getArraysString(bubble));

        int[] selecte = Sort.bubble(getArrays());
        Log.i("测试",getArraysString(selecte));

        int[] insert = Sort.bubble(getArrays());
        Log.i("测试",getArraysString(insert));
    }

    private int[] getArrays(){
        return new int[]{1,5,7,8,3,4,2,6,9,10};
    }

    private String getArraysString(int[] array){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<array.length;i++) {
            sb.append(array[i]);
            if(i!=array.length-1){
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private void dagger2(){
        new Teacher().teacher();

        new Teacher2().teacher();

        new Singleton().person();

        new Qualifier(this).qualifier();
    }



}
