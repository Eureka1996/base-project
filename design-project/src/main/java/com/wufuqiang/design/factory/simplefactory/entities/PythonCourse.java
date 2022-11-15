package com.wufuqiang.design.factory.simplefactory.entities;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 00:20
 */
public class PythonCourse implements ICourse {

    @Override
    public void record() {
        System.out.println("录制Python课程");
    }
}
