package com.wufuqiang.design.proxy.dynamic_proxy;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 11:21
 */
public class Lisi implements IPerson {
    @Override
    public void findLove() {
        System.out.println("李四的要求：是个女的就行");

    }

    @Override
    public void buyInsure() {
        System.out.println("李四买保险");
    }
}
