package com.wufuqiang.design.proxy.static_proxy;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 11:32
 */
public class ProxyTest {
    public static void main(String[] args) {
        ZhangLaoDei zhangLaoDei = new ZhangLaoDei(new Zhangsan());
        zhangLaoDei.findLove();
        zhangLaoDei.setPerson(new Lisi());
        zhangLaoDei.findLove();
    }
}
