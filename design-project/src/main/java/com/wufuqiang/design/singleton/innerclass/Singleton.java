package com.wufuqiang.design.singleton.innerclass;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-16 23:44
 */
public class Singleton {
    private Singleton (){
        if(SingletonInstance.instance != null){
            throw new RuntimeException("不允许非法创建实例");
        }
    }
    // 私有内部类
    private static class SingletonInstance{
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getSingleton() {
        return SingletonInstance.instance;
    }
}
