package com.wufuqiang.design.singleton.container_singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-17 08:38
 */
public class ContainerSingleton {
    private ContainerSingleton(){}

    private static Map<String,Object> ioc = new ConcurrentHashMap<>();

    public static Object getInstance(String className){
        if(!ioc.containsKey(className)){
            Object instance = null;
            try {
                instance = Class.forName(className).newInstance();
                ioc.put(className,instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return instance;
        }else {
            return ioc.get(className);
        }
    }
}
