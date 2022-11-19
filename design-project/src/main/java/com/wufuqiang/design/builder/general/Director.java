package com.wufuqiang.design.builder.general;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-18 23:47
 */
public class Director {
    public static void main(String[] args) {
        IBuilder builder = new ConcreteBuilder();
        System.out.println(builder.build());

    }
}
