package com.wufuqiang.design.factory.abstractfactory;

import com.wufuqiang.design.factory.abstractfactory.entities.INote;
import com.wufuqiang.design.factory.abstractfactory.entities.IVideo;
import com.wufuqiang.design.factory.abstractfactory.entities.JavaNote;
import com.wufuqiang.design.factory.abstractfactory.entities.JavaVideo;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 09:24
 */
public class JavaFactory extends CourseFactory {
    public static void main(String[] args) {

    }

    @Override
    protected INote createNote() {
        init();
        return new JavaNote();
    }

    @Override
    protected IVideo createVideo() {
        init();
        return new JavaVideo();
    }
}
