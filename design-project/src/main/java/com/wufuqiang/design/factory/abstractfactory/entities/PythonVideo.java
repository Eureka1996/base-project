package com.wufuqiang.design.factory.abstractfactory.entities;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 09:21
 */
public class PythonVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("Python视频录制");
    }
}
