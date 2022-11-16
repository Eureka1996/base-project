package com.wufuqiang.design.factory.abstractfactory.entities;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 00:19
 */
public class JavaCourse implements ICourse {

    @Override
    public void record() {
        System.out.println("Java课程的录制");
    }
}
