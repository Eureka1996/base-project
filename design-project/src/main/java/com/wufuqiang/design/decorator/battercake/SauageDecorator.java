package com.wufuqiang.design.decorator.battercake;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 18:00
 */
public class SauageDecorator extends BattercakeDecorator {

    public SauageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"+1根香肠";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+3;
    }
}
