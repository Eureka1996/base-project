package com.wufuqiang.design.command;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-24 19:53
 */
public class GPlayer {
    public void play(){
        System.out.println("正常播放");
    }

    public void speed(){
        System.out.println("拖动进度条");
    }

    public void stop(){
        System.out.println("停止播放");
    }

    public void pause(){
        System.out.println("暂停播放");
    }

}
