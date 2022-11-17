package com.wufuqiang.design.singleton.innerclass_singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 23:45
 */
public class SingletonTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> singletonClass = Singleton.class;
        Constructor<?> declaredConstructor = singletonClass.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        Singleton instance1 = (Singleton)declaredConstructor.newInstance();
        Singleton instance2 = (Singleton)declaredConstructor.newInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
