package com.wufuqiang.design.proxy.general;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 11:05
 */
public class RealSubject implements ISubject {
    @Override
    public void request() {
        System.out.println("real service is called ");
    }
}
