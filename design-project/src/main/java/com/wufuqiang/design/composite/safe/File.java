package com.wufuqiang.design.composite.safe;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 23:58
 */
public class File extends Directory {
    public File(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }
}
