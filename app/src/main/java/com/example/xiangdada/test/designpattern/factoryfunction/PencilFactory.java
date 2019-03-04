package com.example.xiangdada.test.designpattern.factoryfunction;

/**
 * Created by xdd on 2019/2/17
 */
public class PencilFactory extends Factory {
    @Override
    Product create() {
        return new Pencil();
    }
}
