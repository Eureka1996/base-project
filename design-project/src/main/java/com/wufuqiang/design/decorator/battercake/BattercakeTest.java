package com.wufuqiang.design.decorator.battercake;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 18:11
 */
public class BattercakeTest {
    public static void main(String[] args) {

        BattercakeDecorator b1 = new BattercakeDecorator(new BaseBattercake());
        System.out.println(b1.getMsg());
        System.out.println(b1.getPrice());

        b1 = new EggDecorator(b1);
        System.out.println(b1.getMsg());
        System.out.println(b1.getPrice());

        b1 = new EggDecorator(b1);
        System.out.println(b1.getMsg());
        System.out.println(b1.getPrice());

        b1 = new SauageDecorator(b1);
        System.out.println(b1.getMsg());
        System.out.println(b1.getPrice());

    }
}
