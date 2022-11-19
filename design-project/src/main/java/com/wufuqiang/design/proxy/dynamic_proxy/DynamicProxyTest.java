package com.wufuqiang.design.proxy.dynamic_proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-19 13:27
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        JdkMeipo jdkMeipo = new JdkMeipo();
        // 返回的zhangsan跟参数传进去的new Zhangsan()不是同一个Zhangsan
        IPerson zhansan = jdkMeipo.getInstance(new Zhangsan());
        zhansan.findLove();
        zhansan.buyInsure();

        IPerson lisi = jdkMeipo.getInstance(new Lisi());
        lisi.findLove();
        lisi.buyInsure();

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IPerson.class});
        try{
            FileOutputStream os = new FileOutputStream("$Proxy0.class");
            os.write(bytes);
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
