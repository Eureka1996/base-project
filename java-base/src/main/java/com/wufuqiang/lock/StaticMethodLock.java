package com.wufuqiang.lock;

/**
 * @author Wu Fuqiang
 * @date 2021/11/17 5:19 下午
 */
public class StaticMethodLock {
    public static synchronized void test1() throws InterruptedException {
        System.out.println("test1 begin");
        Thread.sleep(100000);
        System.out.println("test1 end");
    }

    public static synchronized void test2(){
        System.out.println("test2 begin");
    }

    public static void main(String[] args) {
        new Thread(()->{
            try {
                StaticMethodLock.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程1").start();

        new Thread(()->{
            StaticMethodLock.test2();
        }).start();
    }
}
