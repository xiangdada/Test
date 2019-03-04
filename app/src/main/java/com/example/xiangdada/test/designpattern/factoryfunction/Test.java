package com.example.xiangdada.test.designpattern.factoryfunction;

/**
 * Created by xdd on 2019/2/17
 */
public class Test {

    public static void createPen(){
        Factory factory = new PenFactory();
        Product product = factory.create();
        product.action();
    }

    public static void createPencil(){
        Factory factory = new PencilFactory();
        Product product = factory.create();
        product.action();
    }
}
