/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 00:43
 */
package com.wufuqiang.design.factory.factorymethod;

import com.wufuqiang.design.factory.simplefactory.entities.ICourse;

public interface ICourseFactory {
    ICourse create();
}
