package com.wufuqiang.design.factory.abstractfactory;

import com.wufuqiang.design.factory.abstractfactory.entities.INote;
import com.wufuqiang.design.factory.abstractfactory.entities.IVideo;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 09:27
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaFactory();
        INote note = courseFactory.createNote();
        IVideo video = courseFactory.createVideo();
        note.edit();
        video.record();

        courseFactory = new PythonFactory();
        note = courseFactory.createNote();
        video = courseFactory.createVideo();
        note.edit();
        video.record();
    }
}
