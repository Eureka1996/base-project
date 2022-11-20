package com.wufuqiang.design.adapter.general.class_adapter;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-20 08:54
 */
public class AdapterTest {
    public static void main(String[] args) {
        DC5 adapter = new PowerAdapter();
        adapter.output5V();
    }
}
