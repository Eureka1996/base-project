package com.wufuqiang.design.singleton.seriable_singleton;

import java.io.Serializable;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-17 09:26
 */
public class SeriableSingleton implements Serializable {
    // 序列化
    // 把内存中对象的状态转换为字节码的形式
    // 把字节码通过IO输出流，写到磁盘上
    // 永久保存下来，持久化
    public  final static SeriableSingleton INSTANCE = new SeriableSingleton();
    private SeriableSingleton(){}

    public static SeriableSingleton getInstance(){
        return INSTANCE;
    }
    // 防止单例对象被序列化和反序列化破坏
    private Object readResolve(){
        return INSTANCE;
    }
}
