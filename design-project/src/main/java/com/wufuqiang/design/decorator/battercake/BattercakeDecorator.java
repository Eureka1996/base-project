package com.wufuqiang.design.decorator.battercake;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 18:00
 */
public class BattercakeDecorator extends Battercake {
    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    @Override
    protected String getMsg() {
        return battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return battercake.getPrice();
    }
}
