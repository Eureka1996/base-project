package com.wufuqiang.design.proxy.cglib_proxy;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 13:50
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"./cglib_proxy_classes");
        Zhangsan zhangsanProxy = (Zhangsan)new CglibMeipo().getInstance(Zhangsan.class);
        zhangsanProxy.findLove();
        zhangsanProxy.buyInsure();


    }
}
