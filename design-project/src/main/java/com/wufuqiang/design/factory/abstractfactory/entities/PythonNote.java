package com.wufuqiang.design.factory.abstractfactory.entities;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 09:23
 */
public class PythonNote implements INote {

    @Override
    public void edit() {
        System.out.println("编辑Python笔记");
    }
}
