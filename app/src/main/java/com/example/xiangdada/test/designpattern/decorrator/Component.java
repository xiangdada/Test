package com.example.xiangdada.test.designpattern.decorrator;

/**
 * Created by xdd on 2019/2/17
 * 被装饰对象的基类，定义一个对象接口，可以给这些对象动态添加职责
 * 比如：泡一杯牛奶喝，一般情况下步骤为：加热水、加奶粉、喝牛奶
 * 但是现在要求在加奶粉之后加点糖、加蜂蜜
 */
public interface Component {
    /**
     * 加热水
     */
    void water();

    /**
     * 加奶粉
     */
    void milk();

    /**
     * 喝牛奶
     */
    void drink();

    void process();
}
