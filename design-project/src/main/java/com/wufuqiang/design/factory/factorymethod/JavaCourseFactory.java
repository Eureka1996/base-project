package com.wufuqiang.design.factory.factorymethod;

import com.wufuqiang.design.factory.simplefactory.entities.ICourse;
import com.wufuqiang.design.factory.simplefactory.entities.JavaCourse;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 00:46
 */
public class JavaCourseFactory implements ICourseFactory {
    public static void main(String[] args) {

    }

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
