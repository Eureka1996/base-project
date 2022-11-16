/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 09:18
 */
package com.wufuqiang.design.factory.abstractfactory;

import com.wufuqiang.design.factory.abstractfactory.entities.INote;
import com.wufuqiang.design.factory.abstractfactory.entities.IVideo;

// 如果工厂没有通用逻辑，可以使用接口；
// 如果有通用逻辑，可以使用抽象类
public abstract class CourseFactory {
    public void init(){
        System.out.println("初始化基础数据");
    }
    protected abstract INote createNote();
    protected abstract IVideo createVideo();
}
