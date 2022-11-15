package com.wufuqiang.design.factory.factorymethod;

import com.wufuqiang.design.factory.simplefactory.entities.ICourse;
import com.wufuqiang.design.factory.simplefactory.entities.PythonCourse;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 00:47
 */
public class PythonCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
