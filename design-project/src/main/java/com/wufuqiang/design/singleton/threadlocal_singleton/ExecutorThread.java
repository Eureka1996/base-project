package com.wufuqiang.design.singleton.threadlocal_singleton;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-17 21:38
 */
public class ExecutorThread implements Runnable {

    @Override
    public void run() {
        System.out.println(ThreadLocalSingleton.getInstance());
    }
}
