package com.wufuqiang.design.proxy.general;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 11:08
 */
public class Proxy implements ISubject {

    private ISubject subject;

    public Proxy(ISubject subject){
        this.subject = subject;
    }

    @Override
    public void request() {
        before();
        subject.request();
        after();
    }

    public void before(){
        System.out.println("called before request().");
    }

    public void after(){
        System.out.println("called after request().");
    }

}
