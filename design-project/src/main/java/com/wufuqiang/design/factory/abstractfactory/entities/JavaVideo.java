package com.wufuqiang.design.factory.abstractfactory.entities;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 09:21
 */
public class JavaVideo implements IVideo {

    @Override
    public void record() {
        System.out.println("Java视频录制");
    }
}
