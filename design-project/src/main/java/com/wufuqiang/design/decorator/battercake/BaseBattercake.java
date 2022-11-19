package com.wufuqiang.design.decorator.battercake;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 18:00
 */
public class BaseBattercake extends Battercake {

    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
