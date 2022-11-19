package com.wufuqiang.design.proxy.dynamic_proxy;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 11:21
 */
public class Zhangsan implements IPerson {
    @Override
    public void findLove() {
        System.out.println("张三的要求：肤白貌美大长腿");

    }

    @Override
    public void buyInsure() {
        System.out.println("张三买保险");
    }
}
