package com.wufuqiang.threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: Wu Fuqiang
 * @create: 2023-06-17 21:59
 */
public class LockSuppportDemo {

    public static void main(String[] args){
        System.out.println("begin park");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("end park");
    }

    @Test
    public void test() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park");
                LockSupport.park();
                System.out.println("child thread unpark.");
            }
        });
        thread.start();

        Thread.sleep(50000);

        System.out.println("main thread begin unpark");

        // 调用unpark方法让thread线程持有许可证,然后park方法返回
        LockSupport.unpark(thread);

    }
}
