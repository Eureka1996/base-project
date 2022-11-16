package com.wufuqiang.design.factory.abstractfactory;

import com.wufuqiang.design.factory.abstractfactory.entities.*;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 09:24
 */
public class PythonFactory extends CourseFactory {
    public static void main(String[] args) {

    }

    @Override
    protected INote createNote() {
        init();
        return new PythonNote();
    }

    @Override
    protected IVideo createVideo() {
        init();
        return new PythonVideo();
    }
}
