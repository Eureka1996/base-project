package com.wufuqiang.design.factory.simplefactory;

import com.wufuqiang.design.factory.simplefactory.entities.ICourse;
import com.wufuqiang.design.factory.simplefactory.entities.JavaCourse;
import com.wufuqiang.design.factory.simplefactory.entities.PythonCourse;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 00:24
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        ICourse course = new SimpleFactory().create(JavaCourse.class.getName());
        course.record();
        course = new SimpleFactory().createByClass(PythonCourse.class);
        course.record();
    }
}
