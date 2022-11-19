package com.wufuqiang.design.composite.safe;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 23:56
 */
public abstract class Directory {
    protected String name;

    public Directory(String name) {
        this.name = name;
    }
    public abstract void show();
}
