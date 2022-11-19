package com.wufuqiang.design.decorator.battercake;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 18:00
 */
public class EggDecorator extends BattercakeDecorator {

    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg()+"+1个鸡蛋";
    }

    @Override
    protected int getPrice() {
        return super.getPrice()+1;
    }
}
