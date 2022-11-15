package com.wufuqiang.design.factory.factorymethod;

import com.wufuqiang.design.factory.simplefactory.entities.ICourse;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 00:49
 */
public class FactoryMethonTest {
    public static void main(String[] args) {
        ICourseFactory courseFactory = new JavaCourseFactory();
        ICourse course = courseFactory.create();
        course.record();

        courseFactory = new PythonCourseFactory();
        course = courseFactory.create();
        course.record();
    }
}
