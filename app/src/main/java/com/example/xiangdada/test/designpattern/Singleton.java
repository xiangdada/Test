package com.example.xiangdada.test.designpattern;

/**
 * Created by xdd on 2019/2/17
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton(){}

    /**
     * 懒汉式
     * 延迟加载，适合单线程，线程不安全，多线程中很容易出现不同步的现象
     * @return
     */
    public static Singleton getInstance1(){
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * volatile：可以保证多线程下的可见性，禁止进行指令重排序；
     * 每当子线程某一语句要用到volatile变量时，都会从主线程重新拷贝一份，这样就保证子线程的会跟主线程的一致
     * 每当子线程某一语句要写volatile变量时，都会在读完后同步到主线程去，这样就保证主线程的变量及时更新
     */
    private static volatile Singleton instance1 = null;
    /**
     * 双重锁
     * 延迟加载，线程安全
     * @return
     */
    public static synchronized Singleton getInstance2(){
        Singleton singleton = instance1;
        if(singleton==null){
            synchronized (Singleton.class){
                singleton = instance1;
                if(singleton == null) {
                    instance1 = new Singleton();
                    singleton = instance1;
                }
            }
        }
        return singleton;
    }


    private static class Holder{
        private static Singleton singleton = new Singleton();
    }

    /**
     * 内部类
     * 延迟加载，线程安全
     * @return
     */
    public static Singleton getInstance3(){
        return Holder.singleton;
    }

    private static Singleton singleton = new Singleton();

    /**
     * 饿汉式
     * 启动时便创建实例，容易造成内存资源浪费，线程安全，
     * @return
     */
    public static Singleton getInstance4(){
        return singleton;
    }


}
