package com.wufuqiang.design.flyweight.general;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 20:48
 */
// 享元工厂
public class FlyweightFactory {
    private static Map<String,IFlyweight> pool = new HashMap<String,IFlyweight>();

    // 因为内部状态具备不变性，因此作为缓存的键
    public static IFlyweight getFlyweight(String intrinsicState){
        if(!pool.containsKey(intrinsicState)){
            IFlyweight flyweight = new ConcreteFlyweight(intrinsicState);
            pool.put(intrinsicState,flyweight);
        }
        return pool.get(intrinsicState);
    }
}
