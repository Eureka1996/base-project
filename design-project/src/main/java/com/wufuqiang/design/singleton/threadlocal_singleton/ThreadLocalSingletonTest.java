package com.wufuqiang.design.singleton.threadlocal_singleton;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-17 21:33
 */
public class ThreadLocalSingletonTest {
    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        new Thread(new ExecutorThread()).start();
        new Thread(new ExecutorThread()).start();
    }
}
