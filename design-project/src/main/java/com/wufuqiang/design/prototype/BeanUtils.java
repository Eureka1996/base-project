package com.wufuqiang.design.prototype;

import java.lang.reflect.Field;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-17 22:08
 */
public class BeanUtils {
    public static Object copy(Object prototype){
        Class<?> clazz = prototype.getClass();
        Object returnValue = null;
        try {
            returnValue = clazz.newInstance();
            for (Field field:clazz.getDeclaredFields()){
                field.setAccessible(true);
                field.set(returnValue,field.get(prototype));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnValue;
    }
}
